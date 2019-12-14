/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {
    private DatagramSocket server;
    private DatagramPacket send,receive;
    private byte[] _send, _receive;
    
    public Server(){
        try{
            server = new DatagramSocket(1109);
            System.out.println("Server running ...");
            _receive = new byte[1024];
            receive = new DatagramPacket(_receive,_receive.length);
            server.receive(receive);
            ByteArrayInputStream bais = new ByteArrayInputStream(_receive);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Student rStudent = (Student) ois.readObject();
            System.out.println(rStudent.toString());
            Student sStudent = new Student(rStudent.getCode());
            sStudent.setId(9);
            sStudent.setGpa(3);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(sStudent);
            _send = baos.toByteArray();
            send = new DatagramPacket(_send,_send.length, receive.getSocketAddress());
            server.send(send);
            server.receive(receive);
            ByteArrayInputStream bais1 = new ByteArrayInputStream(_receive);
            ObjectInputStream ois1 = new ObjectInputStream(bais1);
            Student r1Student = (Student) ois1.readObject();
            System.out.println(r1Student.toString());
            server.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
    }
}
