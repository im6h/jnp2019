/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Vu Hai Dang
 */
public class ImplementProduct extends UnicastRemoteObject implements IProduct, Serializable {
    public ImplementProduct() throws RemoteException{
        super();
    }
    @Override
    public Product getProduct(String studentCode) throws RemoteException {
        Product product = new Product();
        product.setId(1);
        product.setCode("123");
        return product;
    }

    @Override
    public boolean insertProduct(Product product) throws RemoteException {
        System.out.println(product.toString());
        return true;
    }
    
}
