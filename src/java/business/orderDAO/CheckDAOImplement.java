/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.orderDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.order.Check;

/**
 *
 * @author vuvin
 */
public class CheckDAOImplement implements CheckDAO {

    @Override
    public int addCheck(Check check) {
        String sql = "INSERT INTO onlinestore.Check(PaymentID,Name,BankID) VALUES(?,?,?)";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, check.getID());
            preparedStatement.setString(2, check.getName());
            preparedStatement.setString(3, check.getBankID());
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Add accout error");
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public int updateCheck(Check check) {
        String sql = "UPDATE  onlinestore.Check SET Name=?, BankID=? WHERE PaymentID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, check.getName());
            preparedStatement.setString(2, check.getBankID());
            preparedStatement.setInt(3, check.getID());

            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update accout error");
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public int deleteCheck(int checkID) {
        String sql = "DELETE FROM  onlinestore.Check WHERE PaymentID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, checkID);
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update accout error");
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public ArrayList<Check> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
