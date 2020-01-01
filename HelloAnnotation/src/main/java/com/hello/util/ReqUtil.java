package com.hello.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReqUtil {
    public static HttpSession getSession(HttpServletRequest request) {
        return request == null ? null : request.getSession();
    }

    public static String getIP(HttpServletRequest request) {
        if (request == null) {
            return null;
        }

        String s = request.getHeader("X-Forwarded-For");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("WL-Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("HTTP_CLIENT_IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = request.getRemoteAddr();
        if ("127.0.0.1".equals(s) || "0:0:0:0:0:0:0:1".equals(s)) {
            try {
                s = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException unknownhostexception) {
            }
        }
        return s;
    }
}
