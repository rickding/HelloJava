package com.hello.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

@SpringBootTest
public class AiControllerTest {
    @Autowired
    AiController aiController;

    @Test
    public void testTts() throws IOException {
        MockHttpServletResponse response = new MockHttpServletResponse();
        Object ret = aiController.tts(response, "测试AiController");
        System.out.println(ret);
        Assertions.assertEquals("ok", ret);
    }
}
