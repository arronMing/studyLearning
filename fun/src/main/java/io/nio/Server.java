package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server implements Runnable {

    private Selector selector;

    private ByteBuffer readByte = ByteBuffer.allocate(1024);

    private ByteBuffer writeByte = ByteBuffer.allocate(1024);

    public Server(int port) {


        try {
            this.selector = Selector.open();
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(port));
            channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server start, port :" + port);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void run() {

        while (true) {
            try {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();
                    iterator.remove();
                    ;
                    if (key.isValid()) {
                        if (key.isAcceptable()) {
                            this.accept(key);
                        }
                        if (key.isReadable()) {
                            this.read(key);
                        }


                    }

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

    private void read(SelectionKey key) {
        this.readByte.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            int count = channel.read(readByte);
            if (count == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            readByte.flip();
            byte[] bytes = new byte[readByte.remaining()];
            readByte.get(bytes);
            String data = new String(bytes);
            System.out.println("Server : " + data);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void accept(SelectionKey key) {

        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        try {
            SocketChannel sc = channel.accept();
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_ACCEPT);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String args[]) {

        new Thread(new Server(8765)).start();


    }

}
