package com.hello.audio;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class Recorder implements Runnable {
    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(
            1,
            new BasicThreadFactory.Builder().namingPattern("audio-player-pool-%d").daemon(true).build()
    );

    private static Long msDuration = null;
    private static Boolean isRecording = false;

    public static void capture(ByteArrayOutputStream outputStream, TimeListener timeListener, Long millis) {
        System.out.println("Record thread");
        synchronized (Recorder.class) {
            msDuration = millis;
            isRecording = true;
        }

        // 创建录音线程
        Recorder recorder = new Recorder(outputStream, timeListener);
        executorService.execute(recorder);
    }

    public static void stop() {
        stop(0);
    }

    public static void stop(long millis) {
        synchronized (Recorder.class) {
            msDuration = millis;
        }
    }

    public static boolean isRecording() {
        synchronized (Recorder.class) {
            return isRecording;
        }
    }

    private ByteArrayOutputStream byteOutputStream;
    private TimeListener timeListener;

    private Recorder(ByteArrayOutputStream outputStream, TimeListener timeListener) {
        this.byteOutputStream = outputStream;
        this.timeListener = timeListener;
    }

    @Override
    public void run() {
        Date timeStart = new Date();
        System.out.printf("Record start, %s\n", timeStart.toString());

        TargetDataLine targetDataLine = null;
        try {
            AudioFormat audioFormat = FormatUtil.getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
            targetDataLine = (TargetDataLine) (AudioSystem.getLine(info));
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            byte[] bytes = new byte[1024 * 8];
            while (true) {
                // 录音时该线程一直执行, 从数据行的输入缓冲区读取音频数据。
                // 要读取bts.length长度的字节,cnt 是实际读取的字节数
                int cnt = targetDataLine.read(bytes, 0, bytes.length);
                if (cnt > 0) {
                    byteOutputStream.write(bytes, 0, cnt);
                }

                Date timeEnd = new Date();
                long ms = (timeEnd.getTime() - timeStart.getTime());
                System.out.printf("Record %d, seconds: %d, stopped: %s\n", cnt, ms / 1000, String.valueOf(msDuration));

                if (timeListener != null) {
                    timeListener.timeUpdated(ms / 1000);
                }

                synchronized (Recorder.class) {
                    if (msDuration != null && ms >= msDuration) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (targetDataLine != null) {
                targetDataLine.close();
            }

            try {
                byteOutputStream.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        synchronized (Recorder.class) {
            isRecording = false;
        }

        Date timeEnd = new Date();
        long seconds = (timeEnd.getTime() - timeStart.getTime()) / 1000;
        System.out.printf("Record stop, %s, seconds: %d\n", timeEnd.toString(), seconds);
        if (timeListener != null) {
            timeListener.stopped(seconds);
        }
    }
}
