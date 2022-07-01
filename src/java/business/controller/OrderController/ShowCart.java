/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.bookDAO.BookDAO;
import business.bookDAO.BookDAOImplement;
import business.bookDAO.BookItemDAO;
import business.bookDAO.BookItemDAOImplement;
import business.bookDAO.BookLineItemDAO;
import business.bookDAO.BookLineItemDAOImplement;
import business.clothesDAO.ClothesDAO;
import business.clothesDAO.ClothesDAOImplement;
import business.clothesDAO.ClothesItemDAO;
import business.clothesDAO.ClothesItemDAOImplement;
import business.clothesDAO.ClothesLineItemDAO;
import business.clothesDAO.ClothesLineItemDAOImplement;
import business.electronicsDAO.ElectronicsLineItemDAO;
import business.electronicsDAO.ElectronicsLineItemDAOImplement;
import business.customerDAO.AccountDAO;
import business.customerDAO.CustomerDAO;
import business.orderDAO.CartDAO;
import business.orderDAO.CartDAOImplement;
import business.shoesDAO.ShoesLineItemDAO;
import business.shoesDAO.ShoesLineItemDAOImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.book.BookLineItem;
import model.clothes.ClothesLineItem;
import model.customer.Customer;
import model.electronics.ElectronicsLineItem;
import model.order.Cart;
import model.shoes.ShoesLineItem;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "ShowCart", urlPatterns = {"/ShowCart"})
public class ShowCart extends HttpServlet {

    private CartDAO cartDAO;
    private BookLineItemDAO bookLineItemDAO;
    private ClothesLineItemDAO clothesLineItemDAO;
    private ElectronicsLineItemDAO electronicsLineItemDAO;
    private ShoesLineItemDAO shoesLineItemDAO;
    private BookItemDAO bookItemDAO;
    private BookDAO bookDAO;
    private ClothesItemDAO clothesItemDAO;
    private ClothesDAO clothesDAO;

    public void init() {
        cartDAO = new CartDAOImplement();
        bookLineItemDAO = new BookLineItemDAOImplement();
        clothesLineItemDAO = new ClothesLineItemDAOImplement();
        electronicsLineItemDAO = new ElectronicsLineItemDAOImplement();
        shoesLineItemDAO = new ShoesLineItemDAOImplement();
        bookItemDAO = new BookItemDAOImplement();
        bookDAO = new BookDAOImplement();
        clothesItemDAO = new ClothesItemDAOImplement();
        clothesDAO = new ClothesDAOImplement();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Customer customer = (Customer) request.getAttribute("customer");
        //Customer customer = (Customer)request.getSession().getAttribute("customer");
        String s = (String) request.getSession().getAttribute("user");
        int customerID = (int)request.getSession().getAttribute("customerID");
        Cart cart = cartDAO.findByCustomerID(customerID);
        System.out.println(cart.getID());
        if (cart.getID() == -1 && !s.equals("")) {
            cart = new Cart(customerID, 0, new Date(new java.util.Date().getTime()));
            cartDAO.addCart(cart);
            cart = cartDAO.findByCustomerID(customerID);
        }
        ArrayList<BookLineItem> bookLineItems = bookLineItemDAO.findBookLineItemByCartID(cart.getID());
        System.out.println(bookLineItems.size());
        ArrayList<ClothesLineItem> clothesLineItems = clothesLineItemDAO.findClothesLineItemByCartID(cart.getID());
        System.out.println(clothesLineItems.size());
        ArrayList<ElectronicsLineItem> electronicsLineItems = electronicsLineItemDAO.findElectronicsLineItemByCartID(cart.getID());
        System.out.println(electronicsLineItems.size());
        ArrayList<ShoesLineItem> shoesLineItems = shoesLineItemDAO.findShoesLineItemByCartID(cart.getID());
        System.out.println(shoesLineItems.size());
        request.setAttribute("cart", cart);
        request.setAttribute("bookItemDAO", bookItemDAO);
        request.setAttribute("bookDAO", bookDAO);
        request.setAttribute("clothesItemDAO", clothesItemDAO);
                request.setAttribute("clothesDAO", clothesDAO);
        request.setAttribute("electronicsLineItemDAO", electronicsLineItemDAO);
        request.setAttribute("shoesLineItem", shoesLineItemDAO);
        request.getSession().setAttribute("cart", cart);
        request.setAttribute("bookLineItems", bookLineItems);
        request.setAttribute("clothesLineItems", clothesLineItems);
        request.setAttribute("electronicsLineItems", electronicsLineItems);
        request.setAttribute("shoesLineItems", shoesLineItems);
        getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

}
