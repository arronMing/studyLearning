package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String args []){

        InetSocketAddress address = new InetSocketAddress("127.0.0.1",8765);
        SocketChannel sc = null;
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try {
            sc =SocketChannel.open();
            sc.connect(address);

            while (true){

                byteBuffer.put("aaaa".getBytes());
                byteBuffer.flip();
                sc.write(byteBuffer);
                byteBuffer.clear();
            }




        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sc != null){
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
