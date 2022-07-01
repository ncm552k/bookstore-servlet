/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package business.controller.OrderController;

import business.bookDAO.BookLineItemDAO;
import business.bookDAO.BookLineItemDAOImplement;
import business.clothesDAO.ClothesLineItemDAO;
import business.clothesDAO.ClothesLineItemDAOImplement;
import business.electronicsDAO.ElectronicsLineItemDAO;
import business.electronicsDAO.ElectronicsLineItemDAOImplement;
import business.orderDAO.CartDAO;
import business.orderDAO.CartDAOImplement;
import business.shoesDAO.ShoesLineItemDAO;
import business.shoesDAO.ShoesLineItemDAOImplement;
import business.customerDAO.AccountDAO;
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
import model.electronics.ElectronicsLineItem;
import model.order.Cart;
import model.shoes.ShoesLineItem;

/**
 *
 * @author vuvin
 */
@WebServlet(name = "SearchOnCart", urlPatterns = {"/SearchOnCart"})
public class SearchOnCart extends HttpServlet {

    private CartDAO cartDAO;
    private BookLineItemDAO bookLineItemDAO;
    private ClothesLineItemDAO clothesLineItemDAO;
    private ElectronicsLineItemDAO electronicsLineItemDAO;
    private ShoesLineItemDAO shoesLineItemDAO;

    public void init() {
        cartDAO = new CartDAOImplement();
        bookLineItemDAO = new BookLineItemDAOImplement();
        clothesLineItemDAO = new ClothesLineItemDAOImplement();
        electronicsLineItemDAO = new ElectronicsLineItemDAOImplement();
        shoesLineItemDAO = new ShoesLineItemDAOImplement();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = (String) request.getSession().getAttribute("user");
        int customerID = (int)request.getSession().getAttribute("customerID");
        Cart cart = cartDAO.findByCustomerID(customerID);
        System.out.println(cart.getID());
        if (cart.getID() == -1 && !s.equals("")) {
            cart = new Cart(customerID, 0, new Date(new java.util.Date().getTime()));
            cartDAO.addCart(cart);
            cart = cartDAO.findByCustomerID(customerID);
        }
        int id = Integer.parseInt(request.getParameter("searchBox"));
        ArrayList<BookLineItem> bookLineItems = bookLineItemDAO.findBookLineItemByCartID(cart.getID());
        bookLineItems.removeIf((t) -> {
            return t.getBookItemID()!=id; //To change body of generated lambdas, choose Tools | Templates.
        });
        System.out.println(bookLineItems.size());
        ArrayList<ClothesLineItem> clothesLineItems = clothesLineItemDAO.findClothesLineItemByCartID(cart.getID());
        System.out.println(clothesLineItems.size());
        clothesLineItems.removeIf((t) -> {
            return t.getClothesItemID() != id; //To change body of generated lambdas, choose Tools | Templates.
        });
        ArrayList<ElectronicsLineItem> electronicsLineItems = electronicsLineItemDAO.findElectronicsLineItemByCartID(cart.getID());
        System.out.println(electronicsLineItems.size());
        electronicsLineItems.removeIf((t) -> {
            return t.getElectronicsItemID()!=id; //To change body of generated lambdas, choose Tools | Templates.
        });
        ArrayList<ShoesLineItem> shoesLineItems = shoesLineItemDAO.findShoesLineItemByCartID(cart.getID());
        System.out.println(shoesLineItems.size());
        shoesLineItems.removeIf((t) -> {
            return t.getShoesItemID()!= id; //To change body of generated lambdas, choose Tools | Templates.
        });
        request.setAttribute("cart", cart);
        request.getSession().setAttribute("cart", cart);
        request.setAttribute("bookLineItems", bookLineItems);
        request.setAttribute("clothesLineItems", clothesLineItems);
        request.setAttribute("electronicsLineItems", electronicsLineItems);
        request.setAttribute("shoesLineItems", shoesLineItems);
        getServletContext().getRequestDispatcher("/Cart.jsp").forward(request, response);
    }


}
