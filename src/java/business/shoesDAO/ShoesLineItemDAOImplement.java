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
import model.shoes.ShoesLineItem;
import model.order.Cart;
import model.shoes.ShoesLineItem;

/**
 *
 * @author vuvin
 */
public class ShoesLineItemDAOImplement implements ShoesLineItemDAO{

    @Override
    public int updateShoesLineItem(ShoesLineItem shoesLineItem) {
    String sql = "UPDATE  ShoesLineItem SET Quantity=? WHERE ShoesItemID=? AND CartID = ?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, shoesLineItem.getQuantity());
            preparedStatement.setInt(2,shoesLineItem.getShoesItemID());
            preparedStatement.setInt(3,shoesLineItem.getCartID());
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: Update SLI ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public ArrayList<ShoesLineItem> findShoesLineItemByCartID(int cartID) {
        String sql="SELECT * FROM ShoesLineItem WHERE CartID=?";
        Connection connection=JDBC.getConnection();
        ArrayList<ShoesLineItem> shoesLineItems = new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartID);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                ShoesLineItem b = new ShoesLineItem(resultSet.getInt("ShoesItemID"),
                resultSet.getInt("CartID"), resultSet.getInt("Quantity"));
                shoesLineItems.add(b);
                
            }
            return shoesLineItems;
        } 
        catch (Exception e) {
            System.out.println("Error: find SLI by Cart");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return shoesLineItems;
        }
    }

    @Override
    public int deleteByCartID(int cartID) {
        String sql = "DELETE FROM  ShoesLineItem WHERE CartID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartID);
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: delete SLI by Cart ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public int deleteByShoesItemID(int shoesItemID) {
        String sql = "DELETE FROM  ShoesLineItem WHERE ShoesItemID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,shoesItemID);
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: delete SLI by Cart ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }
    @Override
    public int deleteShoesLineItem(ShoesLineItem shoesLineItem) {
        String sql = "DELETE FROM  ShoesLineItem WHERE ShoesItemID=? AND CartID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,shoesLineItem.getShoesItemID());
            preparedStatement.setInt(2,shoesLineItem.getCartID());
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Error: delete SLI by Cart ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }
    
}
