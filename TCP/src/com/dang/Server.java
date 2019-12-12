/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dang;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {

    public static void main(String[] args) {
        InputStream in;
        byte[] b = new byte[1024];
        try {
            ServerSocket server = new ServerSocket(1109);
            System.out.println("Server running...");
            Socket conn = server.accept();
            in = conn.getInputStream();
            in.read(b);
            System.out.println(new String(b).toUpperCase().trim());
            in.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
