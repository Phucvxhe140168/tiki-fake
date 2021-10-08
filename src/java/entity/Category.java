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
public class Category {
    private String caid;
    private String cname;

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Category(String caid, String cname) {
        this.caid = caid;
        this.cname = cname;
    }

    public Category() {
    }

    
    
}
