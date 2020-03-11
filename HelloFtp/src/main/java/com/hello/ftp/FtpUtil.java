package com.hello.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

public class FtpUtil {
    private static FTPClient ftpClient = null;

    private static FTPClient getInst() {
        if (ftpClient == null) {
            synchronized (FtpUtil.class) {
                if (ftpClient == null) {
                    ftpClient = connect("127.0.0.1", 21, "test", "test");
                }
            }
        }

        return ftpClient;
    }

    private static FTPClient connect(String host, int port, String username, String pwd) {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        ftpClient.setDataTimeout(1000 * 120);

        // 取消服务器获取自身Ip地址和提交的host进行匹配，否则当不一致时会报异常。
        ftpClient.setRemoteVerificationEnabled(false);

        String status = null;
        try {
            ftpClient.connect(host, port);
            ftpClient.login(username, pwd);
            status = ftpClient.getStatus();
        } catch (IOException e) {
            System.err.printf("Fail to connect: %s, %d, %s, %s, %s\n", host, port, username, pwd, e.getMessage());
            return null;
        }

        int replyCode = ftpClient.getReplyCode();
        System.out.printf("Connect: %s, %d, %s, %s, %d, %s\n", host, port, username, pwd, replyCode, status);
        if (!FTPReply.isPositiveCompletion(replyCode)) {
            return null;
        }

        System.out.printf("本地主机: %s, %d\n", ftpClient.getLocalAddress(), ftpClient.getLocalPort());
        System.out.printf("被动模式主机: %s, %d\n", ftpClient.getPassiveHost(), ftpClient.getPassivePort());
        System.out.printf("主动模式主机: %s, %d\n", ftpClient.getRemoteAddress(), ftpClient.getRemotePort());
        return ftpClient;
    }

    public static void close() {
        if (ftpClient != null) {
            synchronized (FtpUtil.class) {
                if (ftpClient != null) {
                    try {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    } catch (IOException e) {
                        System.err.printf("Fail to close: %s\n", e.getMessage());
                    }
                }
                ftpClient = null;
            }
        }
    }

    public static boolean upload(String pathname, String fileName, InputStream inputStream) {
        System.out.printf("Start upload: %s\n", fileName);
        FTPClient ftpClient = getInst();

        // 设置被动模式(FTP客户端在docker容器内，需用被动模式)
        ftpClient.enterLocalPassiveMode();

        try {
            // 设置传输的模式为二进制文件类型传输和工作路径
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.makeDirectory(pathname);
            ftpClient.changeWorkingDirectory(pathname);

            ftpClient.storeFile(fileName, inputStream);
        } catch (IOException e) {
            System.err.printf("Fail to upload: %s, %s\n", fileName, e.getMessage());
            return false;
        }

        System.out.printf("Success upload: %s\n", fileName);
        return true;
    }
}