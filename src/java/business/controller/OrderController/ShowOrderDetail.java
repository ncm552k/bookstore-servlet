/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.orderDAO.OrderDAO;
import business.orderDAO.OrderDAOImplement;
import business.orderDAO.PaymentDAO;
import business.orderDAO.PaymentDAOImplement;
import business.orderDAO.ShipmentDAO;
import business.orderDAO.ShipmentDAOImplement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "ShowOrderDetail", urlPatterns = {"/ShowOrderDetail"})
public class ShowOrderDetail extends HttpServlet {

    private OrderDAO orderDAO;
    private PaymentDAO paymentDAO;
    private ShipmentDAO shipmentDAO;
    
    public void init(){
        orderDAO = new OrderDAOImplement();
        paymentDAO = new PaymentDAOImplement();
        shipmentDAO = new ShipmentDAOImplement();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int orderID;
        try{
             orderID= Integer.parseInt(request.getParameter("orderID"));
        }
        catch(NumberFormatException e){
            orderID = (int)request.getAttribute("orderID");
        }
        Order order = orderDAO.getOrder(orderID);
        Payment payment = paymentDAO.getPaymentByOrderID(orderID);
        Shipment shipment = shipmentDAO.getShipmentByOrderID(orderID);
        request.setAttribute("order", order);
        request.setAttribute("payment", payment);
        request.setAttribute("shipment", shipment);
        getServletContext().getRequestDispatcher("/OrderDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
