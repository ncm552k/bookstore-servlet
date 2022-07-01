/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.ItemController;

import business.bookDAO.BookDAOImplement;
import business.bookDAO.BookItemDAOImplement;
import business.orderDAO.CartDAOImplement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.book.BookItem;
import model.book.BookLineItem;
import model.clothes.ClothesLineItem;
import model.order.Cart;


@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        int ID = Integer.parseInt(req.getParameter("ID")); // xItemID
        //System.out.println("In ra bookItemID: "+ID);
        int customerID = (int)(req.getSession().getAttribute("customerID"));
        //System.out.println("In ra customerID: "+customerID);
        int cartID = new CartDAOImplement().getCartByCustomerID(customerID);  
        //System.out.println("In ra cart ID: "+cartID);
        int quanlity = 1; 
        
        if(type.equals("book")){
            BookLineItem bookLineItem = new BookLineItem(ID, cartID , quanlity);
            int check = new CartDAOImplement().kiemTraHang(bookLineItem);
            if(check == 1){
                new CartDAOImplement().addtoCart(bookLineItem);
            }
            else {
                System.out.println("Mat hang nay da co  trong gio");
            }
        }
        
        if(type.equals("clothes")){
            ClothesLineItem clothesLineItem = new ClothesLineItem(ID,cartID  , quanlity);
            try{
            new CartDAOImplement().addtoCart(clothesLineItem);
            }catch(Exception e){
            }
            System.out.println("Them clotheslineitem thanh cong");
        }
        

         getServletContext().getRequestDispatcher("/XemDanhSachSP").forward(req, resp);
          
    }

   
    
    


}
