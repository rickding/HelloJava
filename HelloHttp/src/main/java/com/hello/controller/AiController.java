package com.hello.controller;

import com.alibaba.fastjson.JSONObject;
import com.hello.http.HttpService;
import com.hello.http.RespData;
import com.hello.http.RespJsonObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Api(tags = {"AI云服务调用"})
@RestController
@RequestMapping("/ai")
public class AiController {
    @Autowired
    HttpService httpService;

    String token;

    @ApiOperation("语音合成")
    @GetMapping("/tts")
    public Object tts(HttpServletResponse response, @RequestParam("text") String text) {
        String url = "https://tsn.baidu.com/text2audio";
        Map<String, String> headers = new HashMap<String, String>() {{
            put("Content-Type", "application/x-www-form-urlencoded");
        }};
        Map<String, Object> params = new HashMap<String, Object>() {{
            put("tex", URLEncoder.encode(text));
            put("tok", token());
            put("cuid", "starter_api_http_service");
            put("ctp", "1");
            put("lan", "zh");
            put("spd", "6");
            put("pit", "5");
            put("vol", "5");
            put("per", "0");
            put("aue", "6"); // 3为mp3格式(默认)； 4为pcm-16k；5为pcm-8k；6为wav（内容同pcm-16k）
        }};

        RespData respData = new RespData();
        httpService.sendHttpForm(url, headers, params, respData);

        // Return data
        try {
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(respData.getBytes());
        } catch (IOException e) {
            System.out.printf("写入语音合成数据错误: %s\n", e.getMessage());
        }

        response.setContentLength(respData.getContentLength());
        response.setContentType(respData.getContentType());
        return "ok";
    }

    private String token() {
        if (token == null) {
            synchronized (AiController.class) {
                if (token == null) {
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
                    token = ret.getString("access_token");
                }
            }
        }
        return token;
    }
}
