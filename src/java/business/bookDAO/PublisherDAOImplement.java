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
import model.book.Publisher;

/**
 *
 * @author Admin
 */
public class PublisherDAOImplement implements PublisherDAO{

    @Override
    public Publisher viewPublisher(int PublisherID) {
        String sql = "Select * from Publisher where ID=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, PublisherID);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");              
                String name = resultSet.getString("Name");
                String address=resultSet.getString("Address");
                Publisher p = new Publisher(id, name, address);              
                return p;
            }
        } catch (Exception e) {
            System.out.println("loi publisher"); 
        }
        
        finally{
            JDBC.closeConnection();
        }
        return null;
    }
    
}
