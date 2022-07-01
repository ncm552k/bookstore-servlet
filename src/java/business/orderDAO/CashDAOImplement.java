/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.orderDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.order.Cash;

/**
 *
 * @author vuvin
 */
public class CashDAOImplement implements CashDAO {

    @Override
    public int addCash(Cash cash) {
        String sql = "INSERT INTO Cash(PaymentID,CashTendered) VALUES(?,?)";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cash.getID());
            preparedStatement.setFloat(2,cash.getCashTendered());
            row = preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Add accout error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public int updateCash(Cash cash) {
        String sql = "UPDATE  Cash SET CashTendered=? WHERE PaymentID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setFloat(1,cash.getCashTendered());
            preparedStatement.setInt(2,cash.getID());
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
    public int deleteCash(int cashID) {
        String sql = "DELETE FROM  Cash WHERE PaymentID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cashID);
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
    public ArrayList<Cash> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
