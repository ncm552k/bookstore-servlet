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
public class Order implements Serializable {
    private int ID;
    private Date date;
    private String status;
    private int cartID;
    private int CustomerID;
    public Order() {
    }

    public Order(int ID, Date date, String status) {
        this.ID = ID;
        this.date = date;
        this.status = status;
    }

    public Order(int ID, Date date, String status, int cartID, int CustomerID) {
        this.ID = ID;
        this.date = date;
        this.status = status;
        this.cartID = cartID;
        this.CustomerID = CustomerID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }
    
}
