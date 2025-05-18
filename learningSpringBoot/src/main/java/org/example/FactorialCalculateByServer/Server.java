package org.example.FactorialCalculateByServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try{
            System.out.println("Waiting for client");
            ServerSocket ss = new ServerSocket(9877);
            Socket soc = ss.accept();
            System.out.println("Conection Established");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            int number = Integer.parseInt(in.readLine());
            int value = factorial(number);
            PrintWriter pp = new PrintWriter(soc.getOutputStream(),true);
            pp.println("Server calculate this :" +value);


        }catch (Exception ee){
            ee.printStackTrace();
        }

    }
    public static int factorial(int number){
        if(number==0) return 1;
        return factorial(number-1) * number;
    }
}
