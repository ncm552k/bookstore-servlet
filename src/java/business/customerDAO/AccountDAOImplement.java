package business.customerDAO;

import bussiness.JDBC;
import model.customer.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAOImplement implements AccountDAO{
    
    
    public boolean checkAccountExisted(String userName) {
        String sql = "SELECT * FROM Account WHERE Username=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) return true;
        } 
        catch (Exception e) {
        }
        finally{
            JDBC.closeConnection();
        }
        return false;
    }
    
    public void addAccount(Account account ){
        String sql = "INSERT INTO Account(Username,Password,CustomerId) VALUES(?,?,?)";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUser());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setInt(3,account.getCustomerID());
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Add accout error");
        }
        finally{
            JDBC.closeConnection();
        }
    }
    
    public void updatePassword(Account account){
        String sql = "UPDATE  Account SET Password=? WHERE Username=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getPassword());
            preparedStatement.setString(2, account.getUser());
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Update accout error");
        }
        finally{
            JDBC.closeConnection();
        }
    }
    
    public boolean checkAccountExact(Account account){
        String sql="SELECT Password FROM Account WHERE Username=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getUser());
            ResultSet resultSet=preparedStatement.executeQuery();
            
            if(resultSet.next()&&resultSet.getString("Password").equals(account.getPassword())){
                return true;
            }
        } 
        catch (Exception e) {
            System.out.println("checkAccountExact error");
        }
        finally{
            JDBC.closeConnection();
        }
        return false;
    }
    
    public int getCustomerID(String user){
        String sql="SELECT CustomerId FROM Account WHERE Username=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user);
            ResultSet resultSet=preparedStatement.executeQuery();
            
            if(resultSet.next()) return resultSet.getInt("CustomerId");
        } 
        catch (Exception e) {
            System.out.println("checkAccountExact error");
        }
        finally{
            JDBC.closeConnection();
        }
        return -1;
    }
}
