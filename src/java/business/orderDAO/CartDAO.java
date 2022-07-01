/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.orderDAO;

import java.util.ArrayList;
import model.order.Cart;
import model.book.BookLineItem;
import model.clothes.ClothesLineItem;

/**
 *
 * @author vuvin
 */
public interface CartDAO {
    public  int addCart(Cart cart);
    public int updateCart(Cart cart);
    public int deleteCart(int cartID);
    //
    public Cart findByCustomerID(int customerID);
    //
    public int getCartByCustomerID(int customerID);
    public void addtoCart(BookLineItem bookLineItem);
    public void addtoCart(ClothesLineItem clothesLineItem);
    public double getTotal(int cartID);
//    public void themGioHang(int customerID);
    public ArrayList<Cart> findAll();// bỏ
    public int kiemTraHang(BookLineItem bookLineItem);
    
}
