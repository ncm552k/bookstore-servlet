/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.book;

import java.io.Serializable;

/**
 *
 * @author vuvin
 */
public class BookLineItem implements Serializable {
    private int bookItemID;
    private int cartID;
    private int quantity;

    public BookLineItem() {
    }

    public BookLineItem(int bookItemID, int cartID, int quantity) {
        this.bookItemID = bookItemID;
        this.cartID = cartID;
        this.quantity = quantity;
    }

    public int getBookItemID() {
        return bookItemID;
    }

    public void setBookItemID(int bookItemID) {
        this.bookItemID = bookItemID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
