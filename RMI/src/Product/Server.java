/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

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
            ImplementProduct product = new ImplementProduct();
            Naming.bind("rmi://localhost:8080/product", product);
            System.out.println("Running on port: " + 8080);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
