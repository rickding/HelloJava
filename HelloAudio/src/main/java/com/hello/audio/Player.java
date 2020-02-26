package com.hello.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

class Player implements Runnable {
    public static void asyncPlay(URL fileUrl) {
        if (fileUrl == null) {
            return;
        }

        // 播放进程
        Player player = new Player();
        try {
            player.audioStream = AudioSystem.getAudioInputStream(fileUrl);
        } catch (UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        Thread thread = new Thread(player);
        thread.start();
    }

    public static void asyncPlay(ByteArrayOutputStream byteOutputStream) {
        if (byteOutputStream == null || byteOutputStream.size() <= 0) {
            return;
        }

        // 输入流
        byte[] audioBytes = byteOutputStream.toByteArray();
        int len = audioBytes.length;
        ByteArrayInputStream audioStream = new ByteArrayInputStream(audioBytes);
        AudioFormat audioFormat = FormatUtil.getAudioFormat();

        // 播放进程
        Player player = new Player();
        player.audioFormat = audioFormat;
        player.audioStream = new AudioInputStream(audioStream, audioFormat, len / audioFormat.getFrameSize());

        Thread thread = new Thread(player);
        thread.start();
    }

    private AudioFormat audioFormat;
    private AudioInputStream audioStream;

    private Player() {
    }

    @Override
    public void run() {
        try {
            play(audioStream, audioFormat);
        } catch (LineUnavailableException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (audioStream != null) {
                try {
                    audioStream.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public static void play(AudioInputStream audioStream, AudioFormat audioFormat) throws IOException, LineUnavailableException {
        if (audioStream == null) {
            return;
        }

        if (audioFormat == null) {
            audioFormat = audioStream.getFormat();
        }

        DataLine.Info lineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(lineInfo);
        dataLine.open(audioFormat, 1024);
        dataLine.start();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = audioStream.read(bytes)) > 0) {
            dataLine.write(bytes, 0, len);
        }

        dataLine.drain();
        dataLine.close();
    }
}
