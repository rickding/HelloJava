package com.hello.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RespData implements ResponseHandler<byte[]> {
    private byte[] bytes;
    private String fileName;
    private String fileExt;
    private String contentType;
    private String contentLength;

    public byte[] getBytes() {
        return bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public String getContentType() {
        return contentType;
    }

    public int getContentLength() {
        return contentLength == null ? 0 : Integer.valueOf(contentLength);
    }

    public String saveFile(String filePath) {
        // 本地存储路径
        Path path = Paths.get(filePath);

        // 保存文件数据
        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            System.out.printf("保存文件失败: %s, %s\n", path.toString(), e.getMessage());
            return null;
        }
        return path.toString();
    }

    private String getHeader(HttpResponse response, String header) {
        return response.containsHeader(header) ? response.getFirstHeader(header).getValue() : null;
    }

    @Override
    public byte[] handleResponse(HttpResponse response) throws IOException {
        // 判断响应状态
        if (response.getStatusLine().getStatusCode() >= 300) {
            throw new IOException("HTTP Request is not success, Response code is " + response.getStatusLine().getStatusCode());
        }

        // 读取文件名称，Header: Content-Disposition: attachment;fileName=abc.txt
        String disposition = getHeader(response, "Content-Disposition");
        if (disposition != null && disposition.contains("=")) {
            fileName = disposition.split("=")[1];
        }

        // 读取ContentType: audio/mp3
        contentType = getHeader(response, "Content-Type");
        if (contentType != null && contentType.contains("/")) {
            fileExt = contentType.split("/")[1];
        }

        contentLength = getHeader(response, "Content-Length");

        // 读取返回内容
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            throw new ClientProtocolException("Response contains no content");
        }

        bytes = EntityUtils.toByteArray(entity);
        return bytes;
    }
}
