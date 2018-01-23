package io.netty.udp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.nio.channels.DatagramChannel;

public class ClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramChannel) throws Exception {
        String response = datagramChannel.content().toString(CharsetUtil.UTF_8);

        System.out.println(response);
        channelHandlerContext.close();

    }
}
