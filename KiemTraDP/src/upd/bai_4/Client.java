/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upd.bai_4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    private DatagramPacket sendPack,receivePack;
    private byte[] sendBuff;
    private int port;
    private int sizeBuff;
    
    public Client(){
        try {
            port = 1108;
            client = new DatagramSocket();
            Student student = new Student(1,"Vu Hai Dang");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(student);
            sendBuff = baos.toByteArray();
            sendPack = new DatagramPacket(sendBuff, sendBuff.length, InetAddress.getLocalHost(),port);
            client.send(sendPack);
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public static void main(String[] args) {
        Client client = new Client();
    }
}
