/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.bookDAO.BookItemDAOImplement;
import business.bookDAO.BookLineItemDAOImplement;
import business.clothesDAO.ClothesLineItemDAOImplement;
import business.electronicsDAO.ElectronicsLineItemDAOImplement;
import business.shoesDAO.ShoesLineItemDAOImplement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.book.BookLineItem;
import model.clothes.ClothesLineItem;
import model.electronics.ElectronicsLineItem;
import model.order.Cart;
import model.shoes.ShoesLineItem;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "DeleteItemCart", urlPatterns = {"/deleteItemCart"})
public class DeleteItemCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String book = request.getParameter("bookItemID");
        String clothes= request.getParameter("clothesItemID");
        String electronics = request.getParameter("electronicsItemID");
        String shoes = request.getParameter("shoesItemID");
        if(book!=null){
            int bookItemID = Integer.parseInt(book);
            BookLineItem bookLineItem = new BookLineItem(bookItemID, cart.getID(),0);
            new BookLineItemDAOImplement().deleteBookLineItem(bookLineItem);
        }
        if(clothes!= null){
            int clothesItemID = Integer.parseInt(clothes);
            ClothesLineItem clothesLineItem = new ClothesLineItem(clothesItemID, cart.getID(), 0);
            new ClothesLineItemDAOImplement().deleteClothesLineItem(clothesLineItem);
        }
        if(electronics!=null){
            int electronicsItemID = Integer.parseInt(electronics);
            ElectronicsLineItem electronicsLineItem = new ElectronicsLineItem(electronicsItemID, cart.getID(), 0);
            new ElectronicsLineItemDAOImplement().deleteElectronicsLineItem(electronicsLineItem);
        }
        if(shoes!=null){
            int shoesItemID = Integer.parseInt(shoes);
            ShoesLineItem shoesLineItem = new ShoesLineItem(shoesItemID, cart.getID(), 0);
            new ShoesLineItemDAOImplement().deleteShoesLineItem(shoesLineItem);
        }
        getServletContext().getRequestDispatcher("/ShowCart").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
