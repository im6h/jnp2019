/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp.bai_3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {
    private DatagramSocket client;
    private DatagramPacket sendPack, receivePack, sendPack1;
    private int sizeBuff;
    private byte[] sendBuff, receiveBuff, sendBuff1;
    public Client(){
        try {
            sizeBuff = 1024*4;
            client = new DatagramSocket();
            receiveBuff = new byte[sizeBuff];
            // gửi thông tin sinh viên đi
            Student student = new Student("B16DCCN055");
            sendObj(student);
            Student st = receiveObj();
            Student sendSt = checkGPA(st);
            sendObj(sendSt);
            client.close();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Student checkGPA(Student st){
        float i = st.getGpa();
        if (i>3.7 && i<=4) {
            st.setGpaLetter("A");
        }else if(i>= 3 && i<3.7){
            st.setGpaLetter("B");
        }else if (i>=2 && i<3){
            st.setGpaLetter("C");
        }else if (i>=1 && i<2){
            st.setGpaLetter("D");
        }else {
            st.setGpaLetter("F");
        }
        return st;
    }
   
     public void sendObj(Student student) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(student);
            sendBuff = baos.toByteArray();
            sendPack = new DatagramPacket(sendBuff,sendBuff.length,
                    InetAddress.getLocalHost(),1109);
            client.send(sendPack);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student receiveObj() {
        Student student = null;
        try {
            receivePack = new DatagramPacket(receiveBuff, receiveBuff.length);
            client.receive(receivePack);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveBuff);
            ObjectInputStream ois = new ObjectInputStream(bais);
            student = (Student) ois.readObject();
            System.out.println(student.getCode()+":"+student.getGpa());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return student;
    }
    public static void main(String[] args) {
        Client client = new Client();
    }
}
