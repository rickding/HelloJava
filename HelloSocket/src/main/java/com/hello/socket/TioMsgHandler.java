package com.hello.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.common.WsResponse;
import org.tio.websocket.server.handler.IWsMsgHandler;
import org.tio.websocket.starter.TioWebSocketServerBootstrap;

@Component
public class TioMsgHandler implements IWsMsgHandler {
    @Autowired
    private TioWebSocketServerBootstrap tioServer;

    @Override
    public Object onText(WsRequest wsRequest, String msg, ChannelContext channelContext) throws Exception {
        System.out.printf("收到文本消息：%s\n", msg);

        Tio.sendToAll(
                tioServer.getServerTioConfig(),
                WsResponse.fromText(String.format("转发消息: %s", msg),"utf-8")
        );
        return String.format("收到消息: %s", msg);
    }

    @Override
    public Object onBytes(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception {
        System.out.printf("收到二进制数据：%d\n", bytes.length);
        return null;
    }

    @Override
    public HttpResponse handshake(HttpRequest httpRequest, HttpResponse httpResponse, ChannelContext channelContext) throws Exception {
        return httpResponse;
    }

    @Override
    public void onAfterHandshaked(HttpRequest httpRequest, HttpResponse httpResponse, ChannelContext channelContext) throws Exception {
        System.out.println("连接成功");
    }

    @Override
    public Object onClose(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception {
        System.out.println("关闭连接");
        return null;
    }
}
