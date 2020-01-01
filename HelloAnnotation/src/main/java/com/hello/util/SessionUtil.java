package com.hello.util;

import javax.servlet.http.HttpSession;
import java.util.UUID;

public class SessionUtil {
    public static String getId(HttpSession session) {
        if (session == null) {
            return String.valueOf(System.currentTimeMillis());
        }

        String sid = session.getId();
        if (sid != null && !sid.isEmpty()) {
            return sid;
        }

        // Generate uid
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
            session.setAttribute("uid", uid);
        }

        // Get sid again
        sid = session.getId();
        if (sid == null || sid.isEmpty()) {
            sid = uid.toString();
        }
        return sid;
    }
}
