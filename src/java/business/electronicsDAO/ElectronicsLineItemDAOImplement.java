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
import model.electronics.ElectronicsLineItem;
import model.electronics.ElectronicsLineItem;
import model.electronics.ElectronicsLineItem;
import model.order.Cart;

/**
 *
 * @author vuvin
 */
public class ElectronicsLineItemDAOImplement implements ElectronicsLineItemDAO {

    @Override
    public int updateElectronicsLineItem(ElectronicsLineItem electronicsLineItem) {
        String sql = "UPDATE  ElectronicsLineItem SET Quantity=? WHERE ElectronicsItemID=? AND CartID = ?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, electronicsLineItem.getQuantity());
            preparedStatement.setInt(2,electronicsLineItem.getElectronicsItemID());
            preparedStatement.setInt(3,electronicsLineItem.getCartID());
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Update ELI error");
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public ArrayList<ElectronicsLineItem> findElectronicsLineItemByCartID(int cartID) {
        String sql = "SELECT * FROM electronicsLineItem WHERE CartID=?";
        Connection connection = JDBC.getConnection();
        ArrayList<ElectronicsLineItem> electronicsLineItems = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cartID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ElectronicsLineItem b = new ElectronicsLineItem(resultSet.getInt("electronicsItemID"),
                        resultSet.getInt("CartID"), resultSet.getInt("Quantity"));
                electronicsLineItems.add(b);

            }
            return electronicsLineItems;
        } catch (Exception e) {
            System.out.println("Error: find ELI by Cart");
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
            return electronicsLineItems;
        }
    }

    @Override
    public int deleteByCartID(int cartID) {
        String sql = "DELETE FROM  ElectronicsLineItem WHERE CartID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartID);
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: delete ELI by Cart ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }
    @Override
    public int deleteByElectronicsItemID(int electronicsItemID) {
    String sql = "DELETE FROM  ElectronicsLineItem WHERE ElectronicsItemID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,electronicsItemID);
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: delete ELI by Cart ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }
    @Override
    public int deleteElectronicsLineItem(ElectronicsLineItem electronicsLineItem) {
        String sql = "DELETE FROM  ElectronicsLineItem WHERE ElectronicsItemID=? AND CartID =?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,electronicsLineItem.getElectronicsItemID());
            preparedStatement.setInt(2,electronicsLineItem.getCartID());
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: delete ELI by Cart ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }
       
}
