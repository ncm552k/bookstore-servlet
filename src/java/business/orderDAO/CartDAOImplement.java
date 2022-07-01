/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.orderDAO;

import business.bookDAO.BookItemDAOImplement;
import business.bookDAO.BookLineItemDAO;
import business.bookDAO.BookLineItemDAOImplement;
import business.clothesDAO.ClothesLineItemDAO;
import business.clothesDAO.ClothesLineItemDAOImplement;
import business.electronicsDAO.ElectronicsLineItemDAO;
import business.electronicsDAO.ElectronicsLineItemDAOImplement;
import business.shoesDAO.ShoesLineItemDAO;
import business.shoesDAO.ShoesLineItemDAOImplement;
import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.book.BookItem;
import model.book.BookLineItem;
import model.clothes.ClothesLineItem;
import model.electronics.ElectronicsLineItem;
import model.order.Cart;
import model.order.Order;
import model.shoes.ShoesLineItem;

/**
 *
 * @author vuvin
 */
public class CartDAOImplement implements CartDAO {

    @Override
    public int addCart(Cart cart) {
        //delete bookLineItem
        //delete Order
        String sql = "INSERT INTO Cart(CustomerId,TotalPrice,Created) VALUES(?,?,?)";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getCustomerID());
            preparedStatement.setFloat(2,cart.getTotalPrice());
            preparedStatement.setDate(3, cart.getCreated());
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Add accout error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
        
    }

    @Override
    public int updateCart(Cart cart) {
        String sql = "UPDATE  Cart SET TotalPrice=? WHERE ID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setFloat(1, cart.getTotalPrice());
            preparedStatement.setInt(2,cart.getID());
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Update accout error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public int deleteCart(int cartID) {
        // delete Order, delete LineItem
        String sql = "DELETE FROM  Cart WHERE ID=?";
        Connection connection=JDBC.getConnection();
        OrderDAO orderDAO = new OrderDAOImplement();
        int row = -1;
        try {
            new BookLineItemDAOImplement().deleteByCartID(cartID);
            new ClothesLineItemDAOImplement().deleteByCartID(cartID);
            new ElectronicsLineItemDAOImplement().deleteByCartID(cartID);
            new ShoesLineItemDAOImplement().deleteByCartID(cartID);
            ArrayList<Order> orders = orderDAO.findOrderByCartID(cartID);
            for(Order order: orders){
                orderDAO.deleteOrder(order.getID());
            }
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartID);
            
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Update accout error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }
    @Override
    public Cart findByCustomerID(int id) {
        String sql="SELECT * FROM Cart WHERE CustomerID=?";
        Connection connection=JDBC.getConnection();
        Cart cart = new Cart();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                cart.setID(resultSet.getInt("ID"));
                cart.setCustomerID(resultSet.getInt("CustomerID"));
                cart.setCreated(resultSet.getDate("Created"));
                cart.setTotalPrice(resultSet.getFloat("TotalPrice"));
            }
        } 
        catch (Exception e) {
            System.out.println("checkAccountExact error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return cart;
        }
        
    }
    @Override
    public ArrayList<Cart> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

@Override
    public void addtoCart(BookLineItem bookLineItem) {
        new BookLineItemDAOImplement().addBookLineItem(bookLineItem);  
        //them san pham vao gio hang
    }

    @Override
    public int getCartByCustomerID(int customerID) {
        String sql = "Select ID from Cart where CustomerID=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");                             
                return id;
            }
        } catch (Exception e) {
            System.out.println("loi lay gio hang theo id cua customer bi loi"); 
        }
        
        finally{
            JDBC.closeConnection();
        }
        return -1;
    }

    @Override
    public double getTotal(int cartID) {
        String sql = "Select * from BookLineItem where CartID=?";
        Connection connection=JDBC.getConnection();
        double price =0;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, cartID);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                int  bookItemID= resultSet.getInt("BookItemID");
                int quality = resultSet.getInt("quantity");
                BookItem bookItem = new BookItemDAOImplement().getBookItem(bookItemID);
                price += bookItem.getPrice()*quality;
                
            }
        } catch (Exception e) {
            System.out.println("loi tinh tong so tien cua gio hang"); 
        }
        
        finally{
            JDBC.closeConnection();
        }
        return price;
    }


//    @Override
//    public void themGioHang(int customerID) {
//        String sql = "INSERT INTO Cart(CustomerID,TotalPrice,Created) VALUES(?,?,?)";
//        Connection connection=JDBC.getConnection();
//        try {
//            PreparedStatement preparedStatement=connection.prepareStatement(sql);
//            preparedStatement.setInt(1,customerID);
//            preparedStatement.setFloat(2,0);           
//            preparedStatement.setDate(3,new java.sql.Date(new java.util.Date().getTime()));         
//            preparedStatement.executeUpdate();
//        } 
//        catch (Exception e) {
//            System.out.println("them gio hang moi cho KH bi loi");
//        }
//        finally{
//            JDBC.closeConnection();
//        }
//    }
    @Override
    public void addtoCart(ClothesLineItem clothesLineItem) {        
        new ClothesLineItemDAOImplement().addClothesLineItem(clothesLineItem);
    }
    @Override
    public int kiemTraHang(BookLineItem bookLineItem) {
        int temp = 1 ;
        List<BookLineItem> bookLineItems = new ArrayList<>();
        System.out.println("cartID: "+bookLineItem.getCartID());
        bookLineItems =  new BookLineItemDAOImplement().findBookLineItemByCartID(bookLineItem.getCartID());
        
        for(BookLineItem b : bookLineItems){
            if(b.getBookItemID()== bookLineItem.getBookItemID()){
                temp = 0; // neu hang bi trung thi return 0
            }
        }
        return temp;
        
    }
    
}
