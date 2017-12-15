package io.netty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {



    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        String request = new String(data, "utf-8");
        System.out.println("Server: " + request);

        String response = "我市反馈信息";
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));

    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
