/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author Vu Hai Dang
 */
public class Client {

    public static void main(String[] args) {
        try {
            IProduct _product = (IProduct) Naming.lookup("rmi://localhost:8080/product");
            Product product = _product.getProduct("B16DCCN055");
            System.out.println(product.getId());
            System.out.println(product.getCode());
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("Name");
                String name = in.nextLine();
                System.out.println("Gia nhap");
                float importPrice = in.nextFloat();
                System.out.println("Gia xuat");
                float exportPrice = in.nextFloat();
                product.setName(name);
                product.setImportPrice(importPrice);
                product.setExportPrice(exportPrice);
                if (_product.insertProduct(product)) {
                    System.out.println(product.toString());
                    break;
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
