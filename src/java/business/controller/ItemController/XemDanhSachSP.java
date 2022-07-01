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


@WebServlet(name = "XemDanhSachSP", urlPatterns = {"/XemDanhSachSP"})
public class XemDanhSachSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookItem> listBookItem = new ArrayList<>();
        listBookItem = new BookItemDAOImplement().findAll();
        req.setAttribute("listBookItem", listBookItem);
        BookDAOImplement bd = new BookDAOImplement();
        req.setAttribute("bookDAO", bd);
        
        
        List<ClothesItem> listClothesItem = new ArrayList<>();
        listClothesItem = new ClothesItemDAOImplement().findAll();
        req.setAttribute("listClothesItem",listClothesItem);
        ClothesDAOImplement cd= new ClothesDAOImplement();
        req.setAttribute("clothesDAO", cd);
        
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }
    
}

   
