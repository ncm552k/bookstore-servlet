/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.bookDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.book.BookLineItem;
import model.order.Cart;

/**
 *
 * @author vuvin
 */
public class BookLineItemDAOImplement implements BookLineItemDAO{

    @Override
    public int updateBookLineItem(BookLineItem bookLineItem) {
        String sql = "UPDATE  BookLineItem SET Quantity=? WHERE BookItemID=? AND CartID = ?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookLineItem.getQuantity());
            preparedStatement.setInt(2,bookLineItem.getBookItemID());
            preparedStatement.setInt(3,bookLineItem.getCartID());
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
    public ArrayList<BookLineItem> findBookLineItemByCartID(int cartID) {
         String sql="SELECT * FROM BookLineItem WHERE CartID=?";
        Connection connection=JDBC.getConnection();
        ArrayList<BookLineItem> bookLineItems = new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartID);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                BookLineItem b = new BookLineItem(resultSet.getInt("BookItemID"),
                resultSet.getInt("CartID"), resultSet.getInt("Quantity"));
                bookLineItems.add(b);
                
            }
            return bookLineItems;
        } 
        catch (Exception e) {
            System.out.println("checkAccountExact error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return bookLineItems;
        }
    }

    @Override
    public int deleteByCartID(int  cartID) {
        String sql = "DELETE FROM  BookLineItem WHERE CartID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
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
    public int deleteByBookItemID(int bookItemID) {
        String sql = "DELETE FROM  BookLineItem WHERE BookItemID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookItemID);
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
    public int deleteBookLineItem(BookLineItem bookLineItem) {
    String sql = "DELETE FROM  BookLineItem WHERE BookItemID=? AND CartID =?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookLineItem.getBookItemID());
            preparedStatement.setInt(2,bookLineItem.getCartID());
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
    public void addBookLineItem(BookLineItem bookLineItem) {
        String sql = "Insert into BookLineItem values(?,?,?) ";
        Connection connection=JDBC.getConnection();
        try {
            System.out.println(bookLineItem.getCartID()+ " " + bookLineItem.getBookItemID() +" "+ bookLineItem.getBookItemID() );

            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookLineItem.getCartID());
            preparedStatement.setInt(2,bookLineItem.getBookItemID());
            preparedStatement.setInt(3,bookLineItem.getQuantity());          
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Add BookLineItem  error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
        }
    }    
    
}
