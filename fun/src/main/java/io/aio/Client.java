package io.aio;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class Client implements Runnable {

    private AsynchronousSocketChannel asc;

    public Client() {
        try {
            asc = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        asc.connect(new InetSocketAddress("127.0.0.1", 8765));
    }


    public void write(String data) {
        asc.write(ByteBuffer.wrap(data.getBytes()));
        read();
    }

    private void read() {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        asc.read(byteBuffer);
        byteBuffer.flip();
        byte[] result = new byte[byteBuffer.remaining()];
        byteBuffer.get(result);
        try {
            System.out.println(new String(result, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {


        while (true) {

        }
    }

    public static void main(String args[]) throws InterruptedException {

        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();

        client1.connect();
        client2.connect();
        client3.connect();

        new Thread(client1, "t1").start();
        new Thread(client2, "t2").start();
        new Thread(client3, "t3").start();

        Thread.sleep(2000);
        client1.write("111111");
        client2.write("222222");
        client3.write("333333");


    }
}
