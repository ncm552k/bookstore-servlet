/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.ItemController;

import business.bookDAO.BookDAOImplement;
import business.bookDAO.BookItemDAOImplement;
import business.clothesDAO.ClothesDAOImplement;
import business.clothesDAO.ClothesItemDAOImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.book.BookItem;
import model.clothes.ClothesItem;

/**
 *
 * @author Admin
 */
@WebServlet(name = "TimKiemSP", urlPatterns = {"/TimKiemSP"})
public class TimKiemSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchBox= req.getParameter("searchBox");
        List<BookItem> listBookItem = new ArrayList<>();
        listBookItem = new BookItemDAOImplement().searchBookItem(searchBox);
        BookDAOImplement bd = new BookDAOImplement();
        req.setAttribute("bookDAO", bd);
        
        List<ClothesItem> listClothesItem = new ArrayList<>();
        listClothesItem = new ClothesItemDAOImplement().searchClothesItem(searchBox);
        ClothesDAOImplement cd= new ClothesDAOImplement();
        req.setAttribute("clothesDAO", cd);
        
        req.setAttribute("listBookItem", listBookItem);
        req.setAttribute("listClothesItem", listClothesItem);
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
        
    }

    
}
