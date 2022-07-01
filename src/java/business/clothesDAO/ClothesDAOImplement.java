/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.clothesDAO;

import business.bookDAO.AuthorDAOImplement;
import business.bookDAO.PublisherDAOImplement;
import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.book.Author;
import model.book.Book;
import model.book.Publisher;
import model.clothes.Clothes;

/**
 *
 * @author Admin
 */
public class ClothesDAOImplement implements ClothesDAO{

    @Override
    public Clothes viewClothes(int clothesID) {
        String sql = "Select * from Clothes where ID=?";
        Connection connection = JDBC.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, clothesID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name= resultSet.getString("Name");
                String type = resultSet.getString("Type");
                String material = resultSet.getString("Material");
                String gender=resultSet.getString("Gender");
                String brand=resultSet.getString("Brand");
                String color=resultSet.getString("Color");
                String size=resultSet.getString("Size");
                String img=resultSet.getString("Img");
                Clothes clothes = new Clothes(id, name, type, material, gender, brand, color, size, img);                
                return clothes;
            }
        } catch (Exception e) {
            System.out.println("loi view clothes ");
        } finally {
            JDBC.closeConnection();
        }
        return null;
    }
    
}
