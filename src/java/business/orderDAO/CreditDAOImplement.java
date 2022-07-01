/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.orderDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.order.Credit;

/**
 *
 * @author vuvin
 */
public class CreditDAOImplement implements CreditDAO {

    @Override
    public int addCredit(Credit credit) {
        String sql = "INSERT INTO Credit(PaymentID,Number,Type,expDate) VALUES(?,?,?,?)";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, credit.getID());
            preparedStatement.setString(2, credit.getNumber());
            preparedStatement.setString(3, credit.getType());
            preparedStatement.setDate(4, credit.getExpDate());
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
    public int updateCredit(Credit credit) {
        String sql = "UPDATE  Credit SET Number=?, Type=?, expDate=? WHERE PaymentID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, credit.getNumber());
            preparedStatement.setString(2, credit.getType());
            preparedStatement.setDate(3, credit.getExpDate());
            preparedStatement.setInt(4, credit.getID());

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
    public int deleteCredit(int creditID) {
        String sql = "DELETE FROM  Credit WHERE PaymentID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, creditID);
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
    public ArrayList<Credit> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
