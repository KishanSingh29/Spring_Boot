package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args){
        try{
            System.out.println("Waiting for client ");
            ServerSocket ss = new ServerSocket(9806);
            Socket soc = ss.accept();
            System.out.println("Connection Stablished");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = in.readLine();
            PrintWriter pp = new PrintWriter(soc.getOutputStream(),true);
            pp.println("server says:"+str);
        }catch (Exception ee){
            ee.printStackTrace();
        }

    }

}
