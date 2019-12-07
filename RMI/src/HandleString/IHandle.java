/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleString;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Vu Hai Dang
 */
public interface IHandle extends Remote {
    public String revertString(String _string) throws RemoteException;
    public String trueString(String _string) throws RemoteException;
}
