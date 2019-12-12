/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.string;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {
    public static void main(String[] args) {
        byte[] b = new byte[1024];
        try{
            ServerSocket server = new ServerSocket(1107);
            System.out.println("Server running...");
            Socket conn = server.accept();
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            DataInputStream in = new DataInputStream(conn.getInputStream());
            String name = in.readUTF();
            System.out.println(name);
            String _str = "vu hai dang";
            out.writeUTF(_str);
            String _receive = in.readUTF();
            System.out.println(_receive);
            out.close();
            in.close();
            server.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
