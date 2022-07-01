/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.orderDAO.OrderDAO;
import business.orderDAO.OrderDAOImplement;
import business.customerDAO.AccountDAO;
import java.io.IOException;
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
@WebServlet(name = "ShowOrders", urlPatterns = {"/ShowOrders"})
public class ShowOrders extends HttpServlet {
    private OrderDAO orderDAO;
    @Override
    public void init(){
       orderDAO = new OrderDAOImplement();
    }
        

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = (String) request.getSession().getAttribute("user");
        int customerID = (int)request.getSession().getAttribute("customerID");
        ArrayList<Order> orders;
        orders = orderDAO.findOrderByCustomerID(customerID);
        System.out.println(orders.size());
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/Orders.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
