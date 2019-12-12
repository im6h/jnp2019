/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {
    public static void main(String[] args) {
        try{
            IProduct _product = (IProduct)Naming.lookup("rmi://localhost:8080/product");
            Product product = _product.getProduct("B16DCCN055");
            System.out.println(product.getId());
            System.out.println(product.getCode());
            Scanner in = new Scanner(System.in);
            Product product1 = new Product();
            product1.setName("Hang ton");
            product1.setImportPrice(15);
            product1.setExportPrice(20);
            _product.insertProduct(product1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
