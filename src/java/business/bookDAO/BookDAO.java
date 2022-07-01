/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.bookDAO;

import model.book.Book;

/**
 *
 * @author Admin
 */
public interface BookDAO {
    public Book viewBook(int bookID);
}
