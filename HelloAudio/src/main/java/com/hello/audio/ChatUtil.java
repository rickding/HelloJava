package com.hello.audio;

import com.alibaba.fastjson.JSONObject;
import com.hello.http.HttpUtil;
import com.hello.http.RespJsonObj;
import com.hello.util.B64Util;

import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ChatUtil {
    public static void chat() {
        RecordHelper recordHelper = RecordHelper.getInst();
        final ByteArrayOutputStream data = recordHelper.save(new ByteArrayOutputStream());

        JSONObject ret = HttpUtil.sendHttpPost(
                "http://localhost:8011/speech/walle",
                null, new HashMap<String, Object>() {{
                    put("size", data.size());
                    put("format", "wav");
                    put("audio", B64Util.encode(data.toByteArray()));
                    put("url", "1");
                }}, new RespJsonObj()
        );
        System.out.println(ret);

        if (ret != null && ret.containsKey("msg")) {
            String fileUrl = ret.getString("msg");
            try {
                Player.asyncPlay(new URL(fileUrl));
            } catch (MalformedURLException e) {
                System.err.println(e.getMessage());
            }
        } else {
            // 播放自己的声音吧
            recordHelper.play();
        }
    }
}
