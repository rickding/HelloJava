package com.hello.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Async
public class ReaderJob {
    private static int URL_INDEX = -1;
    private static final String[] URL_ARR = new String[]{
            "https://blog.csdn.net/xiziyidi/article/details/104088036",
            "https://blog.51cto.com/13851865/2468436",
            "https://blog.csdn.net/xiziyidi/article/details/104003262",
            "https://blog.51cto.com/13851865/2467461",
    };

    @Autowired
    Reader reader;

    @Async
    @Scheduled(cron = "0 0/7 * * * *")
    public void read() {
        URL_INDEX = (URL_INDEX + 1) % URL_ARR.length;
        String ret = reader.read(URL_ARR[URL_INDEX]);
        System.out.printf("read: %s\n", ret == null || ret.length() < 50 ? ret : ret.substring(0, 50));
    }
}
