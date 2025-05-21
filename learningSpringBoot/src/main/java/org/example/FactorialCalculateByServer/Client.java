package org.example.FactorialCalculateByServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        try{
            System.out.println("Client Started");
            Socket soc = new Socket("localhost",9877);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a num");
            int number = Integer.parseInt(in.readLine());
            PrintWriter pp = new PrintWriter(soc.getOutputStream(),true);
            pp.println(number);
            BufferedReader bc = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = bc.readLine();
            System.out.println(str);


        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

}