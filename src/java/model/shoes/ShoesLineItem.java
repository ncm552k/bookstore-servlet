/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.shoes;

/**
 *
 * @author vuvin
 */
public class ShoesLineItem {
    private int shoesItemID;
    private int cartID;
    private int quantity;

    public ShoesLineItem() {
    }

    public ShoesLineItem(int shoesItemID, int cartID, int quantity) {
        this.shoesItemID = shoesItemID;
        this.cartID = cartID;
        this.quantity = quantity;
    }

    public int getShoesItemID() {
        return shoesItemID;
    }

    public void setShoesItemID(int shoesItemID) {
        this.shoesItemID = shoesItemID;
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
