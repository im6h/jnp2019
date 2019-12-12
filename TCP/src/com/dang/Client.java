/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dang;

import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {
    public static void main(String[] args) {
        OutputStream out;
        try{
            Socket client = new Socket("127.0.0.1",1109);
            out = client.getOutputStream();
            out.write("tjjone98".getBytes());
            out.close();
            client.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
