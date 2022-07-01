package business.customerDAO;

import bussiness.JDBC;
import model.customer.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAOImplement implements CustomerDAO{
    public  int addCustomer(Customer customer){
        String sql = "INSERT INTO Customer(Phone) VALUES(?)";
        Connection connection=JDBC.getConnection();
        int ID=-1;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,customer.getPhone());
            preparedStatement.executeUpdate();
            ResultSet resultSet=preparedStatement.getGeneratedKeys();
            if(resultSet.next()) ID=resultSet.getInt(1);
            connection.commit();
            customer.setId(ID);
            return ID;
        } 
        catch (Exception e) {
            System.out.println("Them customer khong thanh cong");
            try {
                connection.rollback();
            } 
            catch (SQLException ex) {
            }
        }
        finally{
            JDBC.closeConnection();
        }
        return -1;
    }
    
    public  void updateCustomer(Customer customer){
        String sql = "UPDATE Customer SET Phone=? WHERE ID=?";
        Connection connection=JDBC.getConnection();
        
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getPhone());
            preparedStatement.setInt(2, customer.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } 
        catch (Exception e) {
            System.out.println("Upadate error");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println("Roll back when update");
            }
        }
        
    }
    
    
    public  Customer selectByCustomerID(int customerID){
        String sql="SELECT * FROM Customer WHERE ID=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                String phone=resultSet.getString("phone");
                Customer customer=new Customer(phone);
                return customer;
            }
        } catch (Exception e) {
        }
        finally{
            JDBC.closeConnection();
        }
        return null;
    }
    
    
}
