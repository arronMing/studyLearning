package io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ExecutorService executorService;

    private AsynchronousChannelGroup threadGroup;

    public AsynchronousServerSocketChannel assc;

    public Server(int port) {


        executorService = Executors.newCachedThreadPool();

        try {
            threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 3);

            assc = AsynchronousServerSocketChannel.open();
            assc.bind(new InetSocketAddress(port));
            System.out.println("server start , port : " + port);
            assc.accept(this, new ServerCompletionHandler());
            Thread.sleep(Integer.MAX_VALUE);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server(8765);
    }
}
