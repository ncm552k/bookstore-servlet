/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.bookDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.book.Book;
import model.book.BookItem;
import model.order.Order;

/**
 *
 * @author vuvin
 */
public class BookItemDAOImplement implements BookItemDAO{

    @Override
    public BookItem getBookItem(int bookItemID) {
        String sql="SELECT * FROM BookItem WHERE ID = ?";
        Connection connection=JDBC.getConnection();
        BookItem bookItem = new BookItem();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookItemID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) bookItem = new BookItem(resultSet.getInt("ID")
                    , resultSet.getInt("BookID"), resultSet.getString("Barcode")
                    , resultSet.getDouble("Price"), resultSet.getFloat("Discount"));
            return bookItem;
        } 
        catch (Exception e) {
            System.out.println("Error find Order by CartID ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return bookItem;
        } 
    }
//     @Override
//    public BookItem viewBookItem(int bookItemID) {
//        String sql = "Select * from BookItem where ID=?";
//        Connection connection=JDBC.getConnection();
//        try {
//            PreparedStatement preparedStatement=connection.prepareStatement(sql);
//            preparedStatement.setInt(1, bookItemID);
//            ResultSet resultSet= preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("ID");
//                int bookid=resultSet.getInt("BookID");
//                
//                
//                String barcode=resultSet.getString("Barcode");
//                double price = resultSet.getDouble("Price");
//                float discount =resultSet.getFloat("Discount");
//                BookItem b = new BookItem(id, bookid, barcode, price, discount);
//                return b;
//            }
//        } catch (Exception e) {
//            System.out.println("loi viewbookitem"); 
//        }
//        
//        finally{
//            JDBC.closeConnection();
//        }
//        return null;
//    }
    
    @Override
    public List<BookItem> searchBookItem(String title) {
        List<BookItem> listBookItems = new ArrayList<>();
        for(BookItem bookItem: findAll()){
            int id = bookItem.getBookID();
            Book book = new BookDAOImplement().viewBook(id);
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                listBookItems.add(bookItem);
            }
        }
        return listBookItems;
    }

    @Override
    public List<BookItem> findAll() {
        List<BookItem> listBookItems = new ArrayList<>();
        String sql = "Select *from BookItem";
        Connection connection=JDBC.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery(sql);
            while (resultSet.next()) {             
                int id = resultSet.getInt("ID");
                int bookid=resultSet.getInt("BookID");                               
                String barcode=resultSet.getString("Barcode");
                double price = resultSet.getDouble("Price");
                float discount=resultSet.getFloat("Discount");
                BookItem b = new BookItem(id, bookid, barcode, price, discount);
                listBookItems.add(b);              
            }
        } catch (Exception e) {
            System.out.println("loi viewbookitem"); 
        }
        
        finally{
            JDBC.closeConnection();
        }       
        return listBookItems;
    }
}
