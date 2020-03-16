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
    private String userId;

    public static void sendMessage(String userId, String message) {
        System.out.printf("Send message: %s, %s", userId, message);
        if (StringUtils.isNotBlank(userId) && webSocketMap.containsKey(userId)) {
            webSocketMap.get(userId).sendMessage(message);
        } else {
            System.err.printf("Offline: %s\n", userId);
        }
    }

    private void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.printf("Receive message: %s, %s\n", userId, message);
        sendMessage(String.format("转发消息: %s", message));
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String userId) {
        this.session = session;
        this.userId = userId;

        webSocketMap.put(userId, this);
        System.out.printf("Online: %d, %s\n", webSocketMap.size(), userId);
        sendMessage("连接成功");
    }

    @OnClose
    public void onClose() {
        webSocketMap.remove(userId);
        System.out.printf("Offline: %d, %s\n", webSocketMap.size(), userId);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.err.printf("Error: %s, %s\n", userId, error.getMessage());
    }
}
