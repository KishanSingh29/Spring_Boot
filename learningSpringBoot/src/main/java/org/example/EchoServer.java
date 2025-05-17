package org.example;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args){
        try{
            System.out.println("Waiting for client ");
            ServerSocket ss = new ServerSocket(9806);
            Socket soc = ss.accept();
            System.out.println("Connection Stablished");
        }catch (Exception ee){
            ee.printStackTrace();
        }

    }

}
