/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.book;

import java.io.Serializable;
import model.clothes.*;
import model.book.*;

/**
 *
 * @author vuvin
 */
public class BookItem implements Serializable {
    private int ID;
    private int bookID;
    private String barcode;
    private double price;
    private float discount;

    public BookItem() {
    }

    public BookItem(int ID, int BookID, String Barcode, double price, float discount) {
        this.ID = ID;
        this.bookID = BookID;
        this.barcode = Barcode;
        this.price = price;
        this.discount = discount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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
