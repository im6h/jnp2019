/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.string;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {

    public static void main(String[] args) {
        
        try {
            Socket client = new Socket("127.0.0.1",1107);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            out.writeUTF("B16DCCN055;100");
            String init = in.readUTF();
            StringTokenizer tok = new StringTokenizer(init," ");
            String tmp = "";
            while(tok.hasMoreTokens()){
                tmp+= handleString(tok.nextToken()+" ");
            }
            out.writeUTF(tmp);
            out.close();
            in.close();
            client.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String handleString(String _str){
        String tmp = "";
        String first = _str.substring(0,1).toUpperCase();
        tmp = first+_str.substring(1);
        return tmp;
    }
}
