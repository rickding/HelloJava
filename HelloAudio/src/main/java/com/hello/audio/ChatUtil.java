package com.hello.audio;

import com.hello.http.HttpUtil;
import com.hello.http.RespData;
import com.hello.util.B64Util;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class ChatUtil {
    public static void chat() {
        RecordHelper recordHelper = RecordHelper.getInst();
        final ByteArrayOutputStream data = recordHelper.save(new ByteArrayOutputStream());

        RespData resp = new RespData();
        byte[] ret = HttpUtil.sendHttpPost(
                "http://localhost:8011/speech/walle",
                null, new HashMap<String, Object>() {{
                    put("size", data.size());
                    put("format", "wav");
                    put("audio", B64Util.encode(data.toByteArray()));
                    put("url", "0");
                    put("data", "1");
                }}, resp
        );
        System.out.printf("%s, %s, %s, %d\n",
                resp.getContentType(), resp.getFileName(), resp.getFileExt(), resp.getContentLength()
        );

        if (ret != null && ret.length > 0) {
            Player.asyncPlay(ret);
        } else {
            // 播放自己的声音吧
            recordHelper.play();
        }
    }
}
