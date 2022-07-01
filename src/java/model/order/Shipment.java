/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.order;

import java.io.Serializable;

/**
 *
 * @author vuvin
 */
public class Shipment  implements Serializable{
    private int ID;
    private String codeShip;
    private String selectShip;
    private String address;
    private int paymentID;
    private int orderID;

    public Shipment() {
    }

    public Shipment(int ID, String codeShip, String selectShip, String address, int paymentID, int orderID) {
        this.ID = ID;
        this.codeShip = codeShip;
        this.selectShip = selectShip;
        this.address = address;
        this.paymentID = paymentID;
        this.orderID = orderID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCodeShip() {
        return codeShip;
    }

    public void setCodeShip(String codeShip) {
        this.codeShip = codeShip;
    }

    public String getSelectShip() {
        return selectShip;
    }

    public void setSelectShip(String selectShip) {
        this.selectShip = selectShip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
}
