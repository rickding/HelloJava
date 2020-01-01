package com.hello.util;

import java.util.HashMap;
import java.util.Map;

public class RespUtil {
    public static Map<String, Object> resp(final int code, final String msg, final String... extra) {
        return new HashMap<String, Object>() {{
            put("code", code);
            put("msg", msg);

            if (extra != null && extra.length > 0) {
                put("extra", extra);
            }
        }};
    }
}
