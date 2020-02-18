package com.hello.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@RestController
@RequestMapping("/file")
public class FileController {
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public Object upload(@RequestPart MultipartFile file) {
        // 本地存储路径
        File tmpFile = new File(file.getOriginalFilename());
        String fileName = tmpFile.getName();
        Path path = Paths.get(fileName);

        try {
            // 保存文件数据
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            System.out.printf("保存文件失败: %s, %s\n", path.toString(), e.getMessage());
        }

        return new HashMap<String, Object>() {{
            put("code", "ok");
            put("msg", path.toString());
        }};
    }

    @ApiOperation("下载文件")
    @GetMapping("/{name}")
    public void download(HttpServletResponse response, @PathVariable("name") String name) throws FileNotFoundException {
        // 打开文件
        File file = new File(name);
        if (!file.exists()) {
            throw new FileNotFoundException(String.format("文件不存在: %s", name));
        }

        // 读取文件数据，写入Response输出流
        FileInputStream fileStream = null;
        BufferedInputStream bufferStream = null;
        try {
            fileStream = new FileInputStream(file);
            bufferStream = new BufferedInputStream(fileStream);
            OutputStream outputStream = response.getOutputStream();

            byte[] buffer = new byte[1024 * 100];
            int i;
            while ((i = bufferStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, i);
            }
            System.out.printf("Success download: %s\n", file.getPath());
        } catch (Exception e) {
            System.out.printf("Error when download: %s, %s", file.getPath(), e.getMessage());
        } finally {
            closeStream(bufferStream);
            closeStream(fileStream);
        }
    }

    private void closeStream(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
