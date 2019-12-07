/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upd.bai_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {
    private DatagramSocket client ;
    private DatagramPacket sendPack, receivePack;
    private byte[] sendBuff, receiveBuff;
    int sizeBuff;
    public Client(){
        try {
            sizeBuff = 1024;
            client = new DatagramSocket();
            String _str = ";B16DCCN055;100";
            sendBuff = _str.getBytes();
            sendPack = new DatagramPacket(sendBuff,sendBuff.length,
                    InetAddress.getLocalHost(), 1108);
            client.send(sendPack);
            
            receiveBuff = new byte[sizeBuff];
            receivePack = new DatagramPacket(receiveBuff, receiveBuff.length);
            client.receive(receivePack);
            String receive = new String(receivePack.getData());
            String receive1 = receive.replaceAll("[^a-zA-Z_0-9]","");
            String receive2 = receive.replaceAll("[a-zA-Z_0-9]","");
            String part = receive1.trim();
            String part1 = receive2.trim();
            System.out.println(part);
            System.out.println(part1);
            
            
            
            client.close();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        
    }
}
