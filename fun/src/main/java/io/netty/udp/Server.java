package io.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class Server {


    public  void run(int port) {


        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(eventLoopGroup).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ServerHandler());
        try {
            b.bind(port).sync().channel().closeFuture().await();
        } catch (InterruptedException e) {

        }finally {
            eventLoopGroup.shutdownGracefully();
        }

    }


    public static void main(String args[]) {
        new Server().run(8765);
        new Server().run(8764);
    }

}
