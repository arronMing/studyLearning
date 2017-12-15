package io.netty.分隔符;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;

public class ServerHandler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String data = (String) msg;
        System.out.println("server revive :" + data);
        String response = "服务器响应：" + msg + "$_";
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));

    }
}
