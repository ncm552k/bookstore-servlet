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
@WebServlet(name = "XemChiTietSP", urlPatterns = {"/XemChiTietSP"})
public class XemChiTietSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        
        int ID = Integer.parseInt(req.getParameter("ID"));
        BookDAOImplement bd = new BookDAOImplement();
        req.setAttribute("bookDAO", bd);
        ClothesDAOImplement cd= new ClothesDAOImplement();
        req.setAttribute("clothesDAO", cd);
        int check=0;
        
        if(type.equals("book")){
            check = 1; //book
            req.setAttribute("check", check);
            BookItem bookItem = new BookItemDAOImplement().getBookItem(ID);
            req.setAttribute("bookItem", bookItem);  
        }
        else if (type.equals("clothes")){
            check = 2 ; //clothes
            req.setAttribute("check", check);
            ClothesItem clothesItem = new ClothesItemDAOImplement().getClothesItem(ID);
            req.setAttribute("clothesItem", clothesItem);
        }
        getServletContext().getRequestDispatcher("/productDetail.jsp").forward(req, resp);
    }

    
}
