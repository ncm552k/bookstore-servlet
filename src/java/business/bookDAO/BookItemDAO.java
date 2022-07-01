/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.bookDAO;

import java.util.List;
import model.book.BookItem;

/**
 *
 * @author vuvin
 */
public interface BookItemDAO {
    public BookItem getBookItem(int bookItemID);
    public List<BookItem> searchBookItem(String title);
    public List<BookItem> findAll();
    
}
