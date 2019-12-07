/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleString;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.StringTokenizer;

/**
 *
 * @author Vu Hai Dang
 */
public class ImplementHandle extends UnicastRemoteObject implements IHandle, Serializable {

    public ImplementHandle() throws RemoteException {
        super();
    }

    @Override
    public String revertString(String string) throws RemoteException {
        StringBuilder reverserString = new StringBuilder(string).reverse();
        return reverserString.toString();
    }

    @Override
    public String trueString(String string) throws RemoteException {
        String tmp = "";
        StringTokenizer tok = new StringTokenizer(string, " ");
        while(tok.hasMoreTokens()){
            tmp += convers(tok.nextToken()) + " ";
        }
        return tmp;
    }

    public String convers(String a) {
        String tmp = "";
        tmp += a.valueOf(a.charAt(0)).toUpperCase();
        tmp += a.substring(1);
        return tmp;
    }
}
