package io.netty.分隔符;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            String response = (String) msg;
            System.out.println("client :" + response);
        } finally {

            ReferenceCountUtil.release(msg);
        }
    }
}
