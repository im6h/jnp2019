/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp.bai_1;

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
public class UDPClient {

    private DatagramSocket client;
    private DatagramPacket sendPack, receivePack, sendPack1, receivePack1;
    private byte[] sendBuff, receiveBuff, sendBuff1, receiveBuff1;

    public UDPClient() {
        try {
            client = new DatagramSocket();
            String _str = new String(";B16DCCN055;100");
            sendBuff = _str.getBytes();
            sendPack = new DatagramPacket(sendBuff, sendBuff.length, InetAddress.getLocalHost(), 1107);
            client.send(sendPack);

            receiveBuff = new byte[1024];
            receivePack = new DatagramPacket(receiveBuff, receiveBuff.length);
            client.receive(receivePack);
            String _strReceive = new String(receivePack.getData());
            String[] part = _strReceive.split(";");
            int x = Integer.parseInt(part[1].trim());
            int y = Integer.parseInt(part[2].trim());
            int sum = x + y;
            int mul = x * y;
            int temp1 = x;
            int temp2 = y;
            while (temp1 != temp2) {
                if (temp1 > temp2) {
                    temp1 -= temp2;
                } else {
                    temp2 -= temp1;
                }
            }
            int ucln = temp1;
            int bcnn = (x * y) / ucln;
            String newSend = ";" + ucln + ";" + bcnn + ";" + sum + ";" + mul;
            System.out.println(newSend);
            sendBuff1 = newSend.getBytes();
            sendPack1 = new DatagramPacket(sendBuff1, sendBuff1.length, receivePack.getSocketAddress());
            client.send(sendPack1);

            client.close();

        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        UDPClient client = new UDPClient();
    }
}
