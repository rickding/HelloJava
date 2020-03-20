package com.hello.socket;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/ws/{uid}")
@Component
public class SocketServer {
    private static ConcurrentHashMap<String, SocketServer> webSocketMap = new ConcurrentHashMap<>();

    private Session session;
    private String uid;

    public static void sendMessage(String uid, String msg) {
        System.out.printf("Send message: %s, %s\n", uid, msg);
        if (StringUtils.isNotBlank(uid) && webSocketMap.containsKey(uid)) {
            webSocketMap.get(uid).sendMessage(msg);
        } else {
            System.err.printf("Offline: %s\n", uid);
        }
    }

    public void sendMessage(String msg) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        System.out.printf("Receive message: %s, %s, %s\n", uid, session.getId(), msg);

        for (String uid : webSocketMap.keySet()) {
            sendMessage(uid, String.format("%s消息: %s", uid.equals(this.uid) ? "自己" : "转发", msg));
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {
        this.session = session;
        this.uid = uid;

        webSocketMap.put(uid, this);
        System.out.printf("Online: %d, %s\n", webSocketMap.size(), uid);
        sendMessage("连接成功");
    }

    @OnClose
    public void onClose() {
        webSocketMap.remove(uid);
        System.out.printf("Offline 1, %s, online: %d\n", uid, webSocketMap.size());
    }

    @OnError
    public void onError(Session session, Throwable e) {
        System.err.printf("Error: %s, %s, %s\n", uid, session.getId(), e.getMessage());
    }
}
