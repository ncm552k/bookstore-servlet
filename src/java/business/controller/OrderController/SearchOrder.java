/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.orderDAO.OrderDAO;
import business.orderDAO.OrderDAOImplement;
import business.customerDAO.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.order.Order;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "SearchOrder", urlPatterns = {"/SearchOrder"})
public class SearchOrder extends HttpServlet {
    private OrderDAO orderDAO;
    public void init(){
        orderDAO = new OrderDAOImplement();
    }
        
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerID = (int)request.getSession().getAttribute("customerID");
        ArrayList<Order> orders;
        orders = orderDAO.findOrderByCustomerID(customerID);
        int id = Integer.parseInt(request.getParameter("searchBox"));
        orders.removeIf((t) -> {
            return t.getID()!=id; //To change body of generated lambdas, choose Tools | Templates.
        });
       
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/Orders.jsp").forward(request, response);
    }

}
