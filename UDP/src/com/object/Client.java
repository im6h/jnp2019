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
import java.net.InetAddress;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {
    private DatagramPacket send, receive;
    private DatagramSocket client;
    private byte[] _send, _receive;
    public Client(){
        try{
            client = new DatagramSocket();
            Student sStudent = new Student("B16DCCN055");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(sStudent);
            _send = baos.toByteArray();
            send = new DatagramPacket(_send,_send.length,InetAddress.getLocalHost(),1109);
            client.send(send);
            _receive = new byte[1024];
            receive = new DatagramPacket(_receive,_receive.length);
            client.receive(receive);
            ByteArrayInputStream basi = new ByteArrayInputStream(_receive);
            ObjectInputStream ois = new ObjectInputStream(basi);
            Student student = (Student) ois.readObject();
            System.out.println(student.toString());
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            ObjectOutputStream oos1 = new ObjectOutputStream(baos1);
            oos1.writeObject(reStudent(student));
            _send = baos1.toByteArray();
            send = new DatagramPacket(_send, _send.length,receive.getSocketAddress());
            client.send(send);
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Student reStudent(Student _student){
        float _math = _student.getGpa();
        if (_math >= 3.7 && _math <4) {
            _student.setGpaLetter("A");
        }else if(_math >= 3 && _math < 3.7){
            _student.setGpaLetter("B");
        }else if(_math >= 2.0 && _math < 3){
            _student.setGpaLetter("C");
        }else if(_math >=1.0 && _math <2.0){
            _student.setGpaLetter("D");
        }else{
            _student.setGpaLetter("F");
        }
        return _student;
    }
    public static void main(String[] args) {
        Client client = new Client();
    }
}
