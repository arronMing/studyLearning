package io.netty.heartBeat;

import io.netty.channel.*;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.HashMap;

public class ServerHeartBeatHandler extends ChannelHandlerAdapter {

    private static HashMap<String, String> AUTH_IP_MAP = new HashMap<String, String>();
    private static final String SUCCESS_KEY = "auth_success_key";

    static {
        AUTH_IP_MAP.put("192.168.1.200", "1234");
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof String) {
            auth(ctx, msg);
        } else if (msg instanceof RequestInfo) {
            RequestInfo info = (RequestInfo) msg;
            System.out.println("--------------------------------------------");
            System.out.println("当前主机ip为: " + info.getIp());
        }
    }

    private boolean auth(ChannelHandlerContext ctx, Object msg) {
        String[] ret = ((String) msg).split(",");
        String auth = AUTH_IP_MAP.get(ret[0]);
        if (auth != null && auth.equals(ret[1])) {
            ctx.writeAndFlush(SUCCESS_KEY);
            return true;
        } else {
            ctx.writeAndFlush("auth failure !").addListener(ChannelFutureListener.CLOSE);
            return false;
        }
    }
}
