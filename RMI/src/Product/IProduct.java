/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Vu Hai Dang
 */
public interface IProduct extends Remote {
    public Product getProduct (String studentCode) throws RemoteException;
    public boolean insertProduct(Product product) throws RemoteException;
}
