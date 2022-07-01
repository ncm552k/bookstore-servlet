/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.bookDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.book.Author;
import model.book.Book;
import model.book.Publisher;


/**
 *
 * @author Admin
 */
public class BookDAOImplement implements BookDAO{

    @Override
    public Book viewBook(int bookID) {
        String sql = "Select * from Book where ID=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookID);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                
                int publisherID = resultSet.getInt("PublisherID");
                Publisher p = new PublisherDAOImplement().viewPublisher(publisherID);
                
                int authorID =resultSet.getInt("AuthorID");
                Author a = new AuthorDAOImplement().viewAuthor(authorID);
                
                String ISBN =resultSet.getString("ISBN");
                String title = resultSet.getString("Title");
                String summary =resultSet.getString("Summary");
                int numberOfPage = resultSet.getInt("NumberOfPage");
                String language =resultSet.getString("Language");
                String img = resultSet.getString("Img");                                            
                Book b = new Book(id, ISBN, title, summary, numberOfPage, language, p, a, img);
                return b;
            }
        } catch (Exception e) {
            System.out.println("loi viewbookitem"); 
        }
        
        finally{
            JDBC.closeConnection();
        }
        return null;
    }
   
//    public static void main(String[] args) {
//       
//        System.out.println( new BookDAOImplement().viewBook(1));
//    }
}
