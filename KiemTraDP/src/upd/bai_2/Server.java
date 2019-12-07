/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upd.bai_2;

import java.io.IOException;
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
    private DatagramPacket receiverPack, sendPack;
    private byte[] sendBuff, receiveBuff;
    private int sizeBuff;
    private int port;

    public Server() {

        try {
            port = 1108;
            server = new DatagramSocket(port);

            sizeBuff = 1024;
            receiveBuff = new byte[sizeBuff];
            receiverPack = new DatagramPacket(receiveBuff, receiveBuff.length);
            server.receive(receiverPack);
            String _str = new String(receiverPack.getData());
            String[] part = _str.split(";");
            for (int i = 0; i < part.length; i++) {
                System.out.println(part[i].trim());
            }
            String send = "jkj(&%^$(0JK8=)7$";
            sendBuff = send.getBytes();
            sendPack = new DatagramPacket(sendBuff, sendBuff.length,
                    receiverPack.getSocketAddress());
            server.send(sendPack);
            
            
            server.close();
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();

    }
}
