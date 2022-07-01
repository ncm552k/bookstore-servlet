/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.electronicsDAO;

import business.electronicsDAO.*;
import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.electronics.ElectronicsItem;
import model.order.Order;

/**
 *
 * @author vuvin
 */
public class ElectronicsItemDAOImplement implements ElectronicsItemDAO{

    @Override
    public ElectronicsItem getElectronicsItem(int electronicsItemID) {
        String sql="SELECT * FROM ElectronicsItem WHERE ID = ?";
        Connection connection=JDBC.getConnection();
        ElectronicsItem electronicsItem = new ElectronicsItem();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,electronicsItemID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) electronicsItem = new ElectronicsItem(resultSet.getInt("ID")
                    , resultSet.getInt("ElectronicsID"), resultSet.getString("Barcode")
                    , resultSet.getDouble("Price"), resultSet.getFloat("Discount"));
            return electronicsItem;
        } 
        catch (Exception e) {
            System.out.println("Error find Order by CartID ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return electronicsItem;
        } 
    }
    
}
