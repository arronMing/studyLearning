package io.mina;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class ClientServer {

    static int port = 8082;
    static String ip = "127.0.0.1";

    public static void main(String args []){


        IoConnector connector = new NioSocketConnector();
        connector.setConnectTimeout(3000);
        connector.getFilterChain().addLast("coderc",new ProtocolCodecFilter(
                new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue())
        ));

        connector.setHandler(new MyClientHandler());
        ConnectFuture connect = connector.connect(new InetSocketAddress(ip, port));
        connect.awaitUninterruptibly();
        IoSession session = connect.getSession();
        session.write("wwwwwwww");
        session.getCloseFuture().awaitUninterruptibly();
        connector.dispose();
    }


}
