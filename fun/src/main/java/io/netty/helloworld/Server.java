package io.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class Server {


    public static void main(String args[]) throws InterruptedException {

        EventLoopGroup eventLoopGroup1 = new NioEventLoopGroup();

        EventLoopGroup eventLoopGroup2 = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(eventLoopGroup1, eventLoopGroup2);
        b.channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new ServerHandler());
            }
        });

        ChannelFuture sync = b.bind(8765).sync();
        sync.channel().closeFuture().sync();
        eventLoopGroup1.shutdownGracefully();
        eventLoopGroup2.shutdownGracefully();


    }

}
