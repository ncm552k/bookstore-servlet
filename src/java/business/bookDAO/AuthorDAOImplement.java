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

/**
 *
 * @author Admin
 */
public class AuthorDAOImplement implements AuthorDAO{

    @Override
    public Author viewAuthor(int authorID) {
        String sql = "Select * from Author where ID=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, authorID);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");              
                String name = resultSet.getString("Name");
                String biography =resultSet.getString("Biography");
                                                        
                Author a = new Author(id, name, biography);
                return a;
            }
        } catch (Exception e) {
            System.out.println("loi author"); 
        }
        
        finally{
            JDBC.closeConnection();
        }
        return null;
    }
    
}
