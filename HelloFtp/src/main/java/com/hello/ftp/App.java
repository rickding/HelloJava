package com.hello.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "readme.md";
        InputStream fileStream = new FileInputStream(new File(filePath));

        FtpUtil.upload("app-main", String.format("%d_%s", new Date().getHours(), filePath), fileStream);
        fileStream.close();
    }
}
