package io.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServer {

    public void run(int port) {

        EventLoopGroup eventLoopGroup1 = new NioEventLoopGroup();
        EventLoopGroup eventLoopGroup2 = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        b.group(eventLoopGroup1, eventLoopGroup2).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("http-codec",
                                new HttpServerCodec());
                        pipeline.addLast("aggregator",
                                new HttpObjectAggregator(65536));
                        socketChannel.pipeline().addLast("http-chunked",
                                new ChunkedWriteHandler());
//                        pipeline.addLast("handler",
//                                new WebSocketServerHandler());

                    }
                });
        try {
            Channel channel = b.bind(port).sync().channel();
            System.out.println("Web socket server started at port " + port + '.');
            System.out.println("Open your browser and navigate to http://localhost:" + port + '/');

            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup1.shutdownGracefully();
            eventLoopGroup2.shutdownGracefully();
        }

    }


    public static void main(String args[]) {

        new WebSocketServer().run(8765);

    }

}











