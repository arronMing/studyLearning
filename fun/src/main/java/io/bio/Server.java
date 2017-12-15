package io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String args[]) {

        ServerSocket serverSocket = null;


        try {
            serverSocket = new ServerSocket(8765);
            System.out.println(" server start .. ");
            Socket socket = serverSocket.accept();
            new Thread(new ServerHandler(socket)).start();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
