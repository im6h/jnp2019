/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp.bai_3;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {

    private DatagramSocket server;
    private DatagramPacket sendPack, receivePack, receivePack1;
    private byte[] sendBuff, receiveBuff, receiveBuff1;
    private int sizeBuff;
    private int port;

    public Server() {
        try {
            port = 1109;
            sizeBuff = 1024 * 4;
            receiveBuff = new byte[sizeBuff];
            receiveBuff1 = new byte[sizeBuff];
            server = new DatagramSocket(port);
            System.out.println("Server running on port..." + port);

            // nhận về thông tin sinh viên
            receiveObj();
            // gửi đi thông tin sinh viên yêu cầu
            Student st = new Student(1, "B16DCCN055", (float) 2.6);
            sendObj(st);
            // nhận về thông tin sinh viên đã sửa điểm
            receiveObj();
            server.close();

        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendObj(Student student) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(student);
            sendBuff = baos.toByteArray();
            sendPack = new DatagramPacket(sendBuff, sendBuff.length, receivePack.getSocketAddress());
            server.send(sendPack);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void receiveObj() {
        try {
            receivePack = new DatagramPacket(receiveBuff, receiveBuff.length);
            server.receive(receivePack);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveBuff);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Student student = (Student) ois.readObject();
            System.out.println(student.getCode()+":"+student.getGpaLetter());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
