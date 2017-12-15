package io.netty.分隔符;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class Server {

    public static void main(String args[]) throws InterruptedException {

        EventLoopGroup eventLoopGroup1 = new NioEventLoopGroup();

        EventLoopGroup eventLoopGroup2 = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(eventLoopGroup1, eventLoopGroup2).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                        ByteBuf byteBuf = Unpooled.copiedBuffer("$_".getBytes());
                        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, byteBuf));
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new ServerHandler());

                    }
                });
        ChannelFuture channelFuture = server.bind(8765).sync();
        channelFuture.channel().closeFuture().sync();
        eventLoopGroup1.shutdownGracefully();
        eventLoopGroup2.shutdownGracefully();


    }

}
