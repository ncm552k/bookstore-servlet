/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.clothes;

import java.io.Serializable;

/**
 *
 * @author vuvin
 */
public class ClothesLineItem implements Serializable {
    private int clothesItemID;
    private int cartID;
    private int quantity;

    public ClothesLineItem() {
    }

    public ClothesLineItem(int clothesItemID, int cartID, int quantity) {
        this.clothesItemID = clothesItemID;
        this.cartID = cartID;
        this.quantity = quantity;
    }

    public int getClothesItemID() {
        return clothesItemID;
    }

    public void setClothesItemID(int clothesItemID) {
        this.clothesItemID = clothesItemID;
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
