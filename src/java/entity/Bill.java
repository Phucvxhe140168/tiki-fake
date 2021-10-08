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
public class Bill {
    private String  Bid, datecreate,total,buyName, buyAdderss, buyPhone;

    public Bill() {
    }

    public Bill(String Bid, String datecreate, String total, String buyName, String buyAdderss, String buyPhone) {
        this.Bid = Bid;
        this.datecreate = datecreate;
        this.total = total;
        this.buyName = buyName;
        this.buyAdderss = buyAdderss;
        this.buyPhone = buyPhone;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String Bid) {
        this.Bid = Bid;
    }

    public String getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(String datecreate) {
        this.datecreate = datecreate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getBuyAdderss() {
        return buyAdderss;
    }

    public void setBuyAdderss(String buyAdderss) {
        this.buyAdderss = buyAdderss;
    }

    public String getBuyPhone() {
        return buyPhone;
    }

    public void setBuyPhone(String buyPhone) {
        this.buyPhone = buyPhone;
    }

    @Override
    public String toString() {
        return "Bill{" + "Bid=" + Bid + ", datecreate=" + datecreate + ", total=" + total + ", buyName=" + buyName + ", buyAdderss=" + buyAdderss + ", buyPhone=" + buyPhone + '}';
    }
    
}
