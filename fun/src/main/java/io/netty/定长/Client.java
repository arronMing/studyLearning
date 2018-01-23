package io.netty.定长;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Client {


    public static void main(String args [] ) throws InterruptedException {

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();


        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                        socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(5));
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new clientHandler());

                    }
                });

        ChannelFuture sync = bootstrap.connect("127.0.0.1", 8765).sync();
        sync.channel().writeAndFlush(Unpooled.wrappedBuffer("aaaaabbbbb".getBytes()));
        sync.channel().writeAndFlush(Unpooled.wrappedBuffer("ccccccc".getBytes()));
        sync.channel().closeFuture().sync();
        eventLoopGroup.shutdownGracefully();

    }

}
