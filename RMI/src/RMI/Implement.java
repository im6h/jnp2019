/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Vu Hai Dang
 */
public class Implement extends UnicastRemoteObject implements Serializable,IProduct{
    public Implement() throws RemoteException{
        super();
    }
    
    @Override
    public Product getProduct(String student) throws RemoteException {
        Product product = new Product();
        product.setId(1);
        product.setCode("JKL156");
        return product;
    }

    @Override
    public boolean insertProduct(Product product) throws RemoteException {
        if (product.getExportPrice() < product.getImportPrice()) {
            return false;
        }
        return true;
    }
    
}
