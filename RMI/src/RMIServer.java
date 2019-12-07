
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Hai Dang
 */
public class RMIServer {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(8081);
            RMICalImplement calSever = new RMICalImplement();
            String res = "rmi://localhost:8081/cal";
            Naming.rebind(res, calSever);
            System.out.println("running...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
