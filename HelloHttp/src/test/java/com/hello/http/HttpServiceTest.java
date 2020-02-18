package com.hello.http;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class HttpServiceTest {
    @Autowired
    HttpService httpService;

    @Test
    public void testSendHttpGet() {
        String html = httpService.sendHttpGet("https://www.baidu.com", new RespStr());
        String ret = html.substring(100, 130);
        System.out.println(ret);
        Assertions.assertNotNull(ret);
    }

    @Test
    public void testBaiduToken() throws UnsupportedEncodingException {
        String url = "https://openapi.baidu.com/oauth/2.0/token";
        Map<String, String> headers = new HashMap<String, String>() {{
            put("Content-Type", "application/x-www-form-urlencoded");
        }};
        Map<String, Object> params = new HashMap<String, Object>() {{
            put("grant_type", "client_credentials");
            put("client_id", "kVcnfD9iW2XVZSMaLMrtLYIz");
            put("client_secret", "O9o1O213UgG5LFn0bDGNtoRN3VWl2du6");
        }};

        JSONObject ret = httpService.sendHttpForm(url, headers, params, new RespJsonObj());
        System.out.println(ret);
        Assertions.assertNotNull(ret);

        String token = ret.getString("access_token");
        testBaiduTts(token);
    }

    public void testBaiduTts(String token) throws UnsupportedEncodingException {
        String url = "https://tsn.baidu.com/text2audio";
        Map<String, String> headers = new HashMap<String, String>() {{
            put("Content-Type", "application/x-www-form-urlencoded");
        }};
        Map<String, Object> params = new HashMap<String, Object>() {{
            put("tex", URLEncoder.encode("SpringBoot搭建分布式Web服务脚手架", "UTF-8"));
            put("tok", token);
            put("cuid", "starter_api_http_service");
            put("ctp", "1");
            put("lan", "zh");
            put("spd", "6");
            put("pit", "5");
            put("vol", "5");
            put("per", "1");
            put("aue", "6"); // 3为mp3格式(默认)； 4为pcm-16k；5为pcm-8k；6为wav（内容同pcm-16k）
        }};

        RespData resp = new RespData();
        byte[] ret = httpService.sendHttpForm(url, headers, params, resp);
        Assertions.assertNotNull(ret);

        String file = resp.saveFile(String.format("http_service_test.%s", resp.getFileExt()));
        System.out.println(file);
    }
}
