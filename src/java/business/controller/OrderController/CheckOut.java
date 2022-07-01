/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.bookDAO.BookItemDAOImplement;
import business.bookDAO.BookLineItemDAO;
import business.bookDAO.BookLineItemDAOImplement;
import business.clothesDAO.ClothesItemDAOImplement;
import business.clothesDAO.ClothesLineItemDAO;
import business.clothesDAO.ClothesLineItemDAOImplement;
import business.electronicsDAO.ElectronicsItemDAOImplement;
import business.electronicsDAO.ElectronicsLineItemDAO;
import business.electronicsDAO.ElectronicsLineItemDAOImplement;
import business.orderDAO.CartDAO;
import business.orderDAO.CartDAOImplement;
import business.orderDAO.CashDAO;
import business.orderDAO.CashDAOImplement;
import business.orderDAO.CheckDAO;
import business.orderDAO.CheckDAOImplement;
import business.orderDAO.CreditDAO;
import business.orderDAO.CreditDAOImplement;
import business.orderDAO.OrderDAO;
import business.orderDAO.OrderDAOImplement;
import business.orderDAO.PaymentDAO;
import business.orderDAO.PaymentDAOImplement;
import business.orderDAO.ShipmentDAO;
import business.orderDAO.ShipmentDAOImplement;
import business.shoesDAO.ShoesItemDAOImplement;
import business.shoesDAO.ShoesLineItemDAO;
import business.shoesDAO.ShoesLineItemDAOImplement;
import business.customerDAO.AccountDAO;
import business.customerDAO.AccountDAOImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.book.BookLineItem;
import model.clothes.ClothesLineItem;
import model.electronics.ElectronicsLineItem;
import model.order.Cart;
import model.order.Cash;
import model.order.Check;
import model.order.Credit;
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;
import model.shoes.ShoesLineItem;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "CheckOut", urlPatterns = {"/checkOut"})
public class CheckOut extends HttpServlet {

    private CartDAO cartDAO;
    private BookLineItemDAO bookLineItemDAO;
    private ClothesLineItemDAO clothesLineItemDAO;
    private ElectronicsLineItemDAO electronicsLineItemDAO;
    private ShoesLineItemDAO shoesLineItemDAO;
    private OrderDAO orderDAO;
    private PaymentDAO paymentDAO;
    private ShipmentDAO shipmentDAO;
    private CashDAO cashDAO;
    private CheckDAO checkDAO;
    private CreditDAO creditDAO;

    public void init() {
        cartDAO = new CartDAOImplement();
        bookLineItemDAO = new BookLineItemDAOImplement();
        clothesLineItemDAO = new ClothesLineItemDAOImplement();
        electronicsLineItemDAO = new ElectronicsLineItemDAOImplement();
        shoesLineItemDAO = new ShoesLineItemDAOImplement();
        orderDAO  = new OrderDAOImplement();
        paymentDAO = new PaymentDAOImplement();
        shipmentDAO = new ShipmentDAOImplement();
        cashDAO = new CashDAOImplement();
        checkDAO = new CheckDAOImplement();
        creditDAO = new CreditDAOImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        ArrayList<BookLineItem> bookLineItems = bookLineItemDAO.findBookLineItemByCartID(cart.getID());
        ArrayList<ClothesLineItem> clothesLineItems = clothesLineItemDAO.findClothesLineItemByCartID(cart.getID());
        ArrayList<ElectronicsLineItem> electronicsLineItems = electronicsLineItemDAO.findElectronicsLineItemByCartID(cart.getID());
        ArrayList<ShoesLineItem> shoesLineItems = shoesLineItemDAO.findShoesLineItemByCartID(cart.getID());
        float totalPrice = 0;
        for (BookLineItem bookLI : bookLineItems) {
            int quantity = Integer.parseInt(request.getParameter("book" + bookLI.getBookItemID()));
            bookLI.setQuantity(quantity);
            bookLineItemDAO.updateBookLineItem(bookLI);
            float realPrice = new BookItemDAOImplement().getBookItem(bookLI.getBookItemID()).getRealPrice();
            totalPrice += quantity * realPrice;
        }

        for (ClothesLineItem clothesLI : clothesLineItems) {
            int quantity = Integer.parseInt(request.getParameter("clothes" + clothesLI.getClothesItemID()));
            clothesLI.setQuantity(quantity);
            clothesLineItemDAO.updateClothesLineItem(clothesLI);
            float realPrice = new ClothesItemDAOImplement().getClothesItem(clothesLI.getClothesItemID()).getRealPrice();
            totalPrice += quantity * realPrice;

        }
        for (ElectronicsLineItem electronicsLI : electronicsLineItems) {
            int quantity = Integer.parseInt(request.getParameter("electronics" + electronicsLI.getElectronicsItemID()));
            electronicsLI.setQuantity(quantity);
            electronicsLineItemDAO.updateElectronicsLineItem(electronicsLI);
            float realPrice = new ElectronicsItemDAOImplement().getElectronicsItem(electronicsLI.getElectronicsItemID()).getRealPrice();
            totalPrice += quantity * realPrice;
        }
        for (ShoesLineItem shoesLI : shoesLineItems) {
            int quantity = Integer.parseInt(request.getParameter("shoes" + shoesLI.getShoesItemID()));
            shoesLI.setQuantity(quantity);
            shoesLineItemDAO.updateShoesLineItem(shoesLI);
            float realPrice = new ShoesItemDAOImplement().getShoesItem(shoesLI.getShoesItemID()).getRealPrice();
            totalPrice += quantity * realPrice;
        }
        cart.setTotalPrice(totalPrice);
        
        int customerID = (int)request.getSession().getAttribute("customerID");
        Order order;
        order = new Order(-1, new Date(new java.util.Date().getTime()), "ordering", cart.getID(), customerID);
        Payment payment = new Payment(-1, (int) totalPrice, order.getID());
        request.getSession().setAttribute("cart", cart);
        request.getSession().setAttribute("order", order);
        request.getSession().setAttribute("payment", payment);
        getServletContext().getRequestDispatcher("/Payment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] selectedMethod = request.getParameterValues("shipmentMethod");
        String url = "/Shipment.jsp";
        System.out.println(selectedMethod[0]);

        String codeship = request.getParameter("codeship");
        String address = request.getParameter("address");
        String codeshipMessage = "";
        String addressMessage = "";
        if (codeship == null || codeship.equals("")) {
            codeshipMessage = "please enter name";
            codeship = "";
        }
        if (address == null || address.equals("")) {
            addressMessage = "please enter Bank ID";
            address = "";
        }
        if (codeshipMessage.isEmpty() && addressMessage.isEmpty()) {
            url = "/ShowOrderDetail";
            HttpSession session = request.getSession();
            Order order = (Order) session.getAttribute("order");
            Payment payment = (Payment) session.getAttribute("payment");
            Cash cash = (Cash) session.getAttribute("cash");
            Check check = (Check) session.getAttribute("check");
            Credit credit = (Credit) session.getAttribute("credit");
            Cart cart = (Cart) session.getAttribute("cart");
            Shipment shipment = new Shipment(-1, codeship, selectedMethod[0], address, 0, 0);
            
            //insert order
            order.setStatus("ordered");
            orderDAO.addOrder(order);
            

            //insert payment
            payment.setOrderID(order.getID());
            paymentDAO.addPayment(payment);
            
            if(check != null){
                check.setID(payment.getID());
                checkDAO.addCheck(check);
            }
            if(cash != null){
                cash.setID(payment.getID());
                cashDAO.addCash(cash);
            }
            if(credit != null){
               credit.setID(payment.getID());
                creditDAO.addCredit(credit);
            }
            //insert Shipment
            shipment.setOrderID(order.getID());
            shipment.setPaymentID(payment.getID());
            shipmentDAO.addShipment(shipment);
            request.setAttribute("orderID", order.getID());
        } else {
            url = "/Shipment.jsp";
            request.setAttribute("codeshipMessage", codeshipMessage);
            request.setAttribute("addressMessage", addressMessage);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
