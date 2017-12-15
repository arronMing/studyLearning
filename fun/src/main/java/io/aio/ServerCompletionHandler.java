package io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ServerCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,Server> {
    @Override
    public void completed(AsynchronousSocketChannel result, Server attachment) {
        attachment.assc.accept(attachment,this);
        read(result);

    }

    private void read(AsynchronousSocketChannel result1) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        result1.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                System.out.println("Server -> " + "收到客户端的数据长度为:" + result);
                String data = new String(attachment.array()).trim();
                System.out.println("Server -> " + "收到客户端的数据信息为:" + data);
                String responseData = "返回参数"+data;
                write(result1,responseData);
            }


            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });


    }

    private void write(AsynchronousSocketChannel result, String responseData) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(responseData.getBytes());
        byteBuffer.flip();

        result.write(byteBuffer);


    }

    @Override
    public void failed(Throwable exc, Server attachment) {

    }
}
