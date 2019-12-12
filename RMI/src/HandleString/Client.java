/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleString;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("Input your string");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            IHandle handle = (IHandle) Naming.lookup("rmi://localhost:8082/string");
            System.out.println(handle.trueString(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
