package io.netty.httpserver;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


public class HttpHelloWorldServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

       ChannelPipeline p = socketChannel.pipeline();
       p.addLast(new HttpServerCodec());
        p.addLast(new HttpHelloWorldServerHandler());

    }
}
