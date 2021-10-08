/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Vu X Phuc
 */
public class ProductSale {
    String Username, quantity,quantitySale, Price, Pid;

    public ProductSale() {
    }

    public ProductSale(String Username, String quantity, String quantitySale, String Price, String Pid) {
        this.Username = Username;
        this.quantity = quantity;
        this.quantitySale = quantitySale;
        this.Price = Price;
        this.Pid = Pid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantitySale() {
        return quantitySale;
    }

    public void setQuantitySale(String quantitySale) {
        this.quantitySale = quantitySale;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String Pid) {
        this.Pid = Pid;
    }
    
}
