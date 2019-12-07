
import java.rmi.Naming;
import java.rmi.Remote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Hai Dang
 */
public class RMIClient {
    public static void main(String[] args) {
        try{
            String res = "rmi://localhost:8081/cal";  
            RMICal cal = (RMICal) Naming.lookup(res);
            
            System.out.println(cal.add(3, 4));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
