package com.hello.ftp;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class FtpUtilTest {
    @Test
    public void testUpload() throws IOException {
        String filePath = "readme.md";
        InputStream fileStream = new FileInputStream(new File(filePath));

        boolean ret = FtpUtil.upload("unit-testing", String.format("%d_%s", new Date().getHours(), filePath), fileStream);

        fileStream.close();
        FtpUtil.close();

        Assert.assertTrue(ret);
    }
}
