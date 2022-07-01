/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.shoesDAO;

import business.shoesDAO.*;
import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.shoes.ShoesItem;
import model.order.Order;

/**
 *
 * @author vuvin
 */
public class ShoesItemDAOImplement implements ShoesItemDAO{

    @Override
    public ShoesItem getShoesItem(int shoesItemID) {
        String sql="SELECT * FROM ShoesItem WHERE ID = ?";
        Connection connection=JDBC.getConnection();
        ShoesItem shoesItem = new ShoesItem();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,shoesItemID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) shoesItem = new ShoesItem(resultSet.getInt("ID")
                    , resultSet.getInt("ShoesID"), resultSet.getString("Barcode")
                    , resultSet.getDouble("Price"), resultSet.getFloat("Discount"));
            return shoesItem;
        } 
        catch (Exception e) {
            System.out.println("Error find Order by CartID ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return shoesItem;
        } 
    }
    
}
