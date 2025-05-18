package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try{
            System.out.println("Client Started");
            Socket soc = new Socket("localhost",9806);
            BufferedReader b1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the String");
            String str = b1.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);
            BufferedReader bg = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(bg.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
