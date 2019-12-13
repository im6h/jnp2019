/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(1107);
            System.out.println("Server running ...");
            Socket conn = server.accept();
            ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
            ObjectInputStream ois1 = new ObjectInputStream(conn.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
            Student _student = (Student) ois.readObject();
            System.out.println(_student.toString());
            Student student = new Student(_student.getCode());
            student.setId(9);
            student.setGpa(3);
            oos.writeObject(student);
            Student _student1 = (Student) ois1.readObject();
            System.out.println(_student1);
            oos.close();
            ois.close();
            conn.close();
            server.close();
        }catch(Exception e){
            
        }
    }
}
