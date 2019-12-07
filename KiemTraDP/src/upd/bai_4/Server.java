/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upd.bai_4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    private DatagramPacket sendPack, receivePack;
    private int port;
    private byte[] sendBuff, receiveBuff;
    private int sizeBuff;
    public Server(){
        try {
            port = 1108;
            sizeBuff = 1024*4;
            server = new DatagramSocket(port);
            System.out.println("Server running on.."+ port);
            receiveBuff = new byte[sizeBuff];
            receivePack = new DatagramPacket(receiveBuff, receiveBuff.length);
            server.receive(receivePack);
            ByteArrayInputStream bais = new ByteArrayInputStream(receiveBuff);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Student student = (Student)ois.readObject();
            System.out.println(student.getId());
            System.out.println(student.getName());
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
