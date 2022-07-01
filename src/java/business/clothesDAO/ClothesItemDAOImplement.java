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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.clothes.Clothes;
import model.clothes.ClothesItem;
import model.order.Order;

/**
 *
 * @author vuvin
 */
public class ClothesItemDAOImplement implements ClothesItemDAO{

    @Override
    public ClothesItem getClothesItem(int clothesItemID) {
        String sql="SELECT * FROM ClothesItem WHERE ID = ?";
        Connection connection=JDBC.getConnection();
        ClothesItem clothesItem = new ClothesItem();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,clothesItemID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) clothesItem = new ClothesItem(resultSet.getInt("ID")
                    , resultSet.getInt("ClothesID"), resultSet.getString("Barcode")
                    , resultSet.getDouble("Price"), resultSet.getFloat("Discount"));
            return clothesItem;
        } 
        catch (Exception e) {
            System.out.println("Error find Order by CartID ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return clothesItem;
        } 
    }
    @Override
    public List<ClothesItem> findAll() {
        List<ClothesItem> listClothesItem = new ArrayList<>();
        String sql = "Select *from ClothesItem";
        Connection connection=JDBC.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery(sql);
            while (resultSet.next()) {             
                int ID = resultSet.getInt("ID");
                int clothesID =resultSet.getInt("ClothesID");                               
                String barcode =resultSet.getString("Barcode");
                double price = resultSet.getDouble("Price");
                float discount = resultSet.getFloat("Discount");
                ClothesItem c = new ClothesItem(ID, clothesID, barcode, price, discount);
                listClothesItem.add(c);             
            }
        } catch (Exception e) {
            System.out.println("Loi fill all ClothesItem"); 
        }
        
        finally{
            JDBC.closeConnection();
        }       
        return listClothesItem;
    }

    @Override
    public List<ClothesItem> searchClothesItem(String title) {
        List<ClothesItem> listClothesItems = new ArrayList<>();
        for(ClothesItem clothesItem: findAll()){
            int ID = clothesItem.getClothesID();
            Clothes clothes = new ClothesDAOImplement().viewClothes(ID);
            if(clothes.getName().toLowerCase().contains(title.toLowerCase())){
                listClothesItems.add(clothesItem);
            }
        }
        return listClothesItems;
    }
}
