package com.hello.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class FileControllerTest {
    @Autowired
    FileController fileController;

    @Test
    public void testUpload() throws IOException {
        File file = File.createTempFile("tmp", ".txt");
        MockMultipartFile multipartFile = new MockMultipartFile(
                file.getName(), file.getName(), null,
                new FileInputStream(file)
        );

        Object ret = fileController.upload(multipartFile);
        System.out.println(ret);
        String name = (String) ((Map<String, Object>) ret).get("msg");
        Assertions.assertNotNull(name);

        testDownload(name);
    }

    public void testDownload(String name) {
        Map<String, Boolean> mapIO = new HashMap<String, Boolean>() {{
            put(String.format("%s.txt", new Date().toString()), false);
            put(name, true);
        }};

        MockHttpServletResponse response = new MockHttpServletResponse();
        for (Map.Entry<String, Boolean> io : mapIO.entrySet()) {
            boolean ret = true;
            try {
                fileController.download(response, io.getKey());
            } catch (FileNotFoundException e) {
                System.out.printf("Fail to download: %s\n", e.getMessage());
                ret = false;
            }
            Assertions.assertEquals(io.getValue(), ret);
        }
    }
}
