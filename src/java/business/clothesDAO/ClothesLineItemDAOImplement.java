/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.clothesDAO;

import business.clothesDAO.*;
import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.clothes.ClothesLineItem;
import model.clothes.ClothesLineItem;
import model.order.Cart;

/**
 *
 * @author vuvin
 */
public class ClothesLineItemDAOImplement implements ClothesLineItemDAO {

    @Override
    public int updateClothesLineItem(ClothesLineItem clothesLineItem) {
        String sql = "UPDATE  ClothesLineItem SET Quantity=? WHERE ClothesItemID=? AND CartID = ?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, clothesLineItem.getQuantity());
            preparedStatement.setInt(2,clothesLineItem.getClothesItemID());
            preparedStatement.setInt(3,clothesLineItem.getCartID());
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
    public ArrayList<ClothesLineItem> findClothesLineItemByCartID(int cartID) {
         String sql="SELECT * FROM ClothesLineItem WHERE CartID=?";
        Connection connection=JDBC.getConnection();
        ArrayList<ClothesLineItem> clothesLineItems = new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartID);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                ClothesLineItem b = new ClothesLineItem(resultSet.getInt("ClothesItemID"),
                resultSet.getInt("CartID"), resultSet.getInt("Quantity"));
                clothesLineItems.add(b);
                
            }
            return clothesLineItems;
        } 
        catch (Exception e) {
            System.out.println("checkAccountExact error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return clothesLineItems;
        }
    }

    @Override
    public int deleteByCartID(int cartID) {
        String sql = "DELETE FROM  ClothesLineItem WHERE CartID=?";
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
    public int deleteByClothesItemID(int clothesItemID) {
        String sql = "DELETE FROM  ClothesLineItem WHERE ClothesItemID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,clothesItemID);
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
    public int deleteClothesLineItem(ClothesLineItem clothesLineItem) {
    String sql = "DELETE FROM  ClothesLineItem WHERE ClothesItemID=? AND CartID = ?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,clothesLineItem.getClothesItemID());
            preparedStatement.setInt(2,clothesLineItem.getCartID());
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
    public void addClothesLineItem(ClothesLineItem clothesLineItem) {
        String sql = "Insert into ClothesLineItem values(?,?,?) ";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,clothesLineItem.getCartID());
            preparedStatement.setInt(2,clothesLineItem.getClothesItemID());
            preparedStatement.setInt(3,clothesLineItem.getQuantity());          
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Add ClothesLineItem error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
        }
    }
}
