/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp.bai_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Hai Dang
 */
public class UDPServe {

    private int port;
    private DatagramSocket server;
    private DatagramPacket sendPack, receivePack, receivePack1;
    private byte[] sendBuff, receiveBuff, receiveBuff1;
    private int buffSize;

    public UDPServe() {
        try {
            port = 1107;
            buffSize = 1024;
            server = new DatagramSocket(port);
            System.out.println("Server run on port.. " + port);

            receiveBuff = new byte[buffSize];
            receiveBuff1 = new byte[buffSize];
            receivePack = new DatagramPacket(receiveBuff, receiveBuff.length);

            server.receive(receivePack);
            String _str = new String(receivePack.getData());
            System.out.println(_str);

            String _strSend = new String(";4;6");
            sendBuff = _strSend.getBytes();
            sendPack = new DatagramPacket(sendBuff, sendBuff.length, receivePack.getSocketAddress());
            server.send(sendPack);

            receivePack1 = new DatagramPacket(receiveBuff1, receiveBuff1.length);
            server.receive(receivePack1);
            String str = new String(receivePack1.getData());
            System.out.println(str);
            String[] part = str.split(";");
            System.out.println(part[1].trim());
            System.out.println(part[2].trim());
            System.out.println(part[3].trim());
            System.out.println(part[4].trim());

        } catch (SocketException ex) {
            Logger.getLogger(UDPServe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPServe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        UDPServe server = new UDPServe();
    }
}
