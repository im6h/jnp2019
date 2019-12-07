/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleString;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Vu Hai Dang
 */
public class Server {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(8082);
            ImplementHandle handle = new ImplementHandle();
            Naming.rebind("rmi://localhost:8082/string", handle);
            System.out.println("Running...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
