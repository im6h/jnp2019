
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Hai Dang
 */
public class RMICalImplement extends UnicastRemoteObject implements RMICal, Serializable{
    public RMICalImplement() throws RemoteException{
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException{
        return a+b;
    }
    
}
