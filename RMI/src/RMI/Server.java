/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(8080);
            Implement implement = new Implement();
            Naming.bind("rmi://localhost:8080/product",implement);
            System.out.println("Running on port: " + 8080);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
