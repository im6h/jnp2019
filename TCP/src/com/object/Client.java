/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.object;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket client = new Socket("127.0.0.1",1107);
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            ObjectOutputStream oos1 = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            Student student = new Student("B16DCCN055");
            oos.writeObject(student);
            Student _student = (Student) ois.readObject();
            System.out.println(_student.toString());
            Student stu = convert(_student);
            oos1.writeObject(stu);
            oos.close();
            oos1.close();
            ois.close();
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Student convert(Student _student){
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
}
