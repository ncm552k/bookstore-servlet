/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.bookDAO;

import java.util.ArrayList;
import java.util.List;
import model.book.BookLineItem;
import model.electronics.ElectronicsLineItem;
import model.order.Cart;

/**
 *
 * @author vuvin
 */
public interface BookLineItemDAO {
    public int updateBookLineItem(BookLineItem bookLineItem);
    public ArrayList<BookLineItem> findBookLineItemByCartID(int cartID);
    public int deleteByCartID(int cartID);
    public int deleteByBookItemID(int bookItemID);
    public int deleteBookLineItem(BookLineItem bookLineItem);
public void addBookLineItem(BookLineItem bookLineItem);
}
