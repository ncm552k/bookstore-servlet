/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.orderDAO.CartDAO;
import business.orderDAO.CartDAOImplement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.order.Cart;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "DeleteCart", urlPatterns = {"/DeleteCart"})
public class DeleteCart extends HttpServlet {
    private CartDAO cartDAO;
    public void init(){
        cartDAO = new CartDAOImplement();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cartID = Integer.parseInt(request.getParameter("cartID"));
        cartDAO.deleteCart(cartID);
        getServletContext().getRequestDispatcher("/ShowCart").forward(request, response);
    }

}
