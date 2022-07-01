/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author vuvin
 */
public class Cart implements Serializable {
    private int ID;
    private Date created;
    private float totalPrice;
    private int customerID;
    
    public Cart() {
        totalPrice = 0;
        ID = -1;
    }

    public Cart(int ID, Date created, float totalPrice, int customerID) {
        this.ID = ID;
        this.created = created;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
    }

    public Cart(int customerID, float totalPrice, Date created) {
        this.created = created;
        this.totalPrice = totalPrice;
        this.customerID = customerID;
    }

    public Cart(int cartID) {
        this.ID = cartID;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    
}
