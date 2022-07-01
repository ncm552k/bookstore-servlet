/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.electronics;

import java.io.Serializable;

/**
 *
 * @author vuvin
 */
public class ElectronicsLineItem implements Serializable{
    private int electronicsItemID;
    private int cartID;
    private int quantity;

    public ElectronicsLineItem() {
    }

    public ElectronicsLineItem(int electronicsItemID, int cartID, int quantity) {
        this.electronicsItemID = electronicsItemID;
        this.cartID = cartID;
        this.quantity = quantity;
    }

    public int getElectronicsItemID() {
        return electronicsItemID;
    }

    public void setElectronicsItemID(int electronicsItemID) {
        this.electronicsItemID = electronicsItemID;
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
