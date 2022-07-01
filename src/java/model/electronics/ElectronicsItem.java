/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.electronics;

import java.io.Serializable;
import model.book.*;

/**
 *
 * @author vuvin
 */
public class ElectronicsItem implements Serializable{
    private int ID;
    private int electronicsItemID;
    private String barcode;
    private double price;
    private float discount;

    public ElectronicsItem() {
    }

    public ElectronicsItem(int ID, int electronicsItemID, String barcode, double price, float discount) {
        this.ID = ID;
        this.electronicsItemID = electronicsItemID;
        this.barcode = barcode;
        this.price = price;
        this.discount = discount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getElectronicsItemID() {
        return electronicsItemID;
    }

    public void setElectronicsItemID(int electronicsItemID) {
        this.electronicsItemID = electronicsItemID;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getRealPrice(){
        return (1f-discount)*(float)price;
    }
    
    
}
