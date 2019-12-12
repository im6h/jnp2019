/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author Vu Hai Dang
 */
public class Product implements Serializable{
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code;
    private String name;
    private float ImportPrice;
    private float ExportPrice;
    private String createUser;

    public Product() {
    }
    

    public Product(int id, String code, String name, float ImportPrice, float ExportPrice, String createUser) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.ImportPrice = ImportPrice;
        this.ExportPrice = ExportPrice;
        this.createUser = createUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(float ImportPrice) {
        this.ImportPrice = ImportPrice;
    }

    public float getExportPrice() {
        return ExportPrice;
    }

    public void setExportPrice(float ExportPrice) {
        this.ExportPrice = ExportPrice;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", ImportPrice=" + ImportPrice + ", ExportPrice=" + ExportPrice + ", createUser=" + createUser + '}';
    }
    
}
