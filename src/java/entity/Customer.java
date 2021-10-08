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
public class Customer {
    private String cUserName, cPassWord, FullName, phone, address;
    private double money;
    private int Cid, Pid;

    public Customer() {
    }

    public Customer(String cUserName, String cPassWord, String FullName, String phone, String address, double money, int Cid, int Pid) {
        this.cUserName = cUserName;
        this.cPassWord = cPassWord;
        this.FullName = FullName;
        this.phone = phone;
        this.address = address;
        this.money = money;
        this.Cid = Cid;
        this.Pid = Pid;
    }

    public String getcUserName() {
        return cUserName;
    }

    public void setcUserName(String cUserName) {
        this.cUserName = cUserName;
    }

    public String getcPassWord() {
        return cPassWord;
    }

    public void setcPassWord(String cPassWord) {
        this.cPassWord = cPassWord;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int Pid) {
        this.Pid = Pid;
    }
    
}
