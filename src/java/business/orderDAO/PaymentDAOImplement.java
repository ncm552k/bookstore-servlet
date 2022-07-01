/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.orderDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.order.Cart;
import model.order.Cash;
import model.order.Check;
import model.order.Credit;
import model.order.Order;
import model.order.Payment;

/**
 *
 * @author vuvin
 */
public class PaymentDAOImplement implements PaymentDAO {

    @Override
    public int addPayment(Payment payment) {
        String sql = "INSERT INTO Payment(OrderID,Amount) VALUES(?,?)";
        Connection connection=JDBC.getConnection();
        int ID = -1;
        try {
            
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,payment.getOrderID());
            preparedStatement.setInt(2,payment.getAmount());
           
            ID = preparedStatement.executeUpdate();
            connection.commit();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if(resultSet.next()) ID=resultSet.getInt(1);
            connection.commit();
            payment.setID(ID);
            return ID;
        } 
        catch (Exception e) {
            System.out.println("Add accout error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            
            try {
                connection.rollback();
            } 
            catch (SQLException ex) {
            }
            return ID;
        }
    }

    @Override
    public int updatePayment(Payment payment) {
        String sql = "UPDATE  Payment SET Amount=? WHERE ID=?";
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,payment.getAmount());
            preparedStatement.setInt(2,payment.getID());
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
    public int deletePayment(Payment payment) {
        //delete Cash, Check, Credit
        String sql = "DELETE FROM  Payment WHERE ID=?";
        Cash cash = new Cash();
        cash.setID(payment.getID());
        Check check = new Check();
        check.setID(payment.getID());
        Credit credit = new Credit();
        credit.setID(payment.getID());
        Connection connection=JDBC.getConnection();
        int row = -1;
        try {
            //delete Cash
            new CashDAOImplement().deleteCash(cash.getID());
            //delete Check
            new CheckDAOImplement().deleteCheck(check.getID());
            //delete Check
            new CreditDAOImplement().deleteCredit(credit.getID());
            //delete Payment
            connection.prepareStatement(sql);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, payment.getID());
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
    public int deletePaymentByOrderID(int orderID) {
        ArrayList<Payment> payments = findByOrderID(orderID);
            for(Payment p : payments){
                deletePayment(p);              
            }
            return 1;
    }
    
    private  ArrayList<Payment> findByOrderID(int orderID) {
        String sql="SELECT * FROM Payment WHERE OrderID=?";
        Connection connection=JDBC.getConnection();
        ArrayList<Payment> payments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderID);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Payment p = new Payment();
                p.setID(resultSet.getInt("ID"));
                payments.add(p);
                
            }
            return payments;
        } 
        catch (Exception e) {
            System.out.println("checkAccountExact error");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return payments;
        }
        
    }
 @Override
    public ArrayList<Payment> findPaymentByOrderID(int orderID) {
        String sql="SELECT * FROM Payment WHERE OrderID = ?";
        Connection connection=JDBC.getConnection();
        ArrayList<Payment> payments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,orderID);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Payment p= new Payment(resultSet.getInt("ID"), resultSet.getInt("Amount")
                        , resultSet.getInt("OrderID"));
                
                payments.add(p);
                
            }
            return payments;
        } 
        catch (Exception e) {
            System.out.println("Error find Order by CartID ");
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
            return payments;
        } 
    }
    @Override
    public ArrayList<Payment> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment getPayment(int paymentID) {
        String sql="SELECT * FROM Payment WHERE ID=?";
        Connection connection=JDBC.getConnection();
        Payment payment = new Payment();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, paymentID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                 payment = new Payment(resultSet.getInt("ID"), resultSet.getInt("Amount"), resultSet.getInt("OrderID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
        }
        return payment;
    }

    @Override
    public Payment getPaymentByOrderID(int orderID) {
        String sql="SELECT * FROM Payment WHERE OrderID=?";
        Connection connection=JDBC.getConnection();
        Payment payment = new Payment();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                payment = new Payment(resultSet.getInt("ID"), resultSet.getInt("Amount"), resultSet.getInt("OrderID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            JDBC.closeConnection();
        }
        return payment;
    }
   
}
