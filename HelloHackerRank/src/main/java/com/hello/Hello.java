package com.hello;

import java.util.HashMap;
import java.util.Map;

public class Hello {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
        }};

        System.out.println(map.toString());
        System.out.println(map.keySet().toString());
    }
}
