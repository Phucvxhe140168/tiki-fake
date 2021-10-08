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
public class BillDetail {
    private String Bid, Pid, quantity, price;

    public BillDetail() {
    }

    public BillDetail(String Bid, String Pid, String quantity, String price) {
        this.Bid = Bid;
        this.Pid = Pid;
        this.quantity = quantity;
        this.price = price;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String Bid) {
        this.Bid = Bid;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String Pid) {
        this.Pid = Pid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
