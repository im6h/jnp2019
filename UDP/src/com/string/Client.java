/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.string;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {
    private DatagramSocket client;
    private DatagramPacket sendPack, receivePack;
    private byte[] _send,_receive;
    public Client(){
        try{
            client = new DatagramSocket();
            String _str = new String(";B16DCCN055;100");
            _send = _str.getBytes();
            sendPack = new DatagramPacket(_send, _send.length, InetAddress.getLocalHost(),1109);
            client.send(sendPack);
            _receive = new byte[1024];
            receivePack = new DatagramPacket(_receive,_receive.length);
            client.receive(receivePack);
            String str = new String(receivePack.getData());
            System.out.println(str);
            StringTokenizer tok = new StringTokenizer(str," ");
            String _str1 = "";
            while(tok.hasMoreTokens()){
                _str1 += handleString(tok.nextToken()) + " ";
            }
            byte[] _sendBuff = _str1.getBytes();
            DatagramPacket _sendPack = new DatagramPacket(_sendBuff, _sendBuff.length,receivePack.getSocketAddress());
            client.send(_sendPack);
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String handleString(String _str){
        String tmp = "";
        tmp = _str.substring(0,1).toUpperCase()+ _str.substring(1);
        return tmp;
    }
    
    public static void main(String[] args) {
        Client client = new Client();
    }
}
