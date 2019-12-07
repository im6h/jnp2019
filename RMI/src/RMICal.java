
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Hai Dang
 */
public interface RMICal extends Remote{
    public int add(int a,int b) throws RemoteException;
}
