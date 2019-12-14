/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.string;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {
    private DatagramPacket _send, _receive;
    private DatagramSocket server;
    private byte[] _sendBuff, _receiveBuff;
    
    public Server(){
        try{
            int buffSize = 1024;
            _receiveBuff = new byte[1024];
            server = new DatagramSocket(1109);
            System.out.println("Server running ...");
            _receive = new DatagramPacket(_receiveBuff, _receiveBuff.length);
            server.receive(_receive);
            String str = new String(_receive.getData());
            System.out.println(str);
            String _str = new String("vu hai dang");
            _sendBuff = _str.getBytes();
            _send = new DatagramPacket(_sendBuff, _sendBuff.length,_receive.getSocketAddress());
            server.send(_send);
            DatagramPacket _receive1 = new DatagramPacket(_receiveBuff, _receiveBuff.length);
            server.receive(_receive1);
            String str1= new String(_receive1.getData());
            System.out.println(str1);
            server.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
    }
}
