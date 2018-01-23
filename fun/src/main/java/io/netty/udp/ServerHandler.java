package io.netty.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

public class ServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {

        String req = datagramPacket.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        channelHandlerContext.writeAndFlush(new DatagramPacket(
                Unpooled.copiedBuffer("谚语查询结果", CharsetUtil.UTF_8), datagramPacket.sender()));

    }
}
