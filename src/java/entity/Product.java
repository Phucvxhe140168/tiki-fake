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
public class Product {
    private int id;
    private String  name, image;
    private double price;
    private int quantity, willsale;    
    private String  decription;
    private String Cid, CaID;

    public Product(int id, String name, String image, double price, int quantity, int willsale, String decription, String Cid, String CaID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.willsale = willsale;
        this.decription = decription;
        this.Cid = Cid;
        this.CaID = CaID;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWillsale() {
        return willsale;
    }

    public void setWillsale(int willsale) {
        this.willsale = willsale;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getCaID() {
        return CaID;
    }

    public void setCaID(String CaID) {
        this.CaID = CaID;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", willsale=" + willsale + ", decription=" + decription + ", Cid=" + Cid + ", CaID=" + CaID + '}';
    }

    
    
}