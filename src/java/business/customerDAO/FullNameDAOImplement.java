package business.customerDAO;

import bussiness.JDBC;
import model.customer.FullName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FullNameDAOImplement implements FullNameDAO{
    public void addFullName(FullName fullName){
        String sql = "INSERT INTO FullName(FullName,LastName,FirstName,CustomerId) VALUES(?,?,?,?)";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,fullName.getFullName());
            preparedStatement.setString(2,fullName.getLastName());
            preparedStatement.setString(3,fullName.getFirstName());
            preparedStatement.setInt(4, fullName.getCustomerID());
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("Add fullname error");
        }
        finally{
            JDBC.closeConnection();
        }
    }
    
    public void updateFullName(FullName fullName){
        String sql = "UPDATE FullName SET FullName=?,LastName=?,FirstName=? WHERE CustomerId=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,fullName.getFullName());
            preparedStatement.setString(2,fullName.getLastName());
            preparedStatement.setString(3,fullName.getFirstName());
            preparedStatement.setInt(4, fullName.getCustomerID());
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("updateFullName error");
        }
        finally{
            JDBC.closeConnection();
        }
    }
    
    public  FullName selectByCustomerID(int customerID){
        String sql = "SELECT * FROM FullName WHERE customerID=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,customerID);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                String fullName=resultSet.getString("fullName");
                String firstName=resultSet.getString("firstName");
                String lastName=resultSet.getString("lastName");
                int id=resultSet.getInt("ID");
                FullName name=new FullName(fullName, lastName, firstName, customerID);
                name.setId(id);
                return name;
                
            }
        } 
        catch (Exception e) {
            System.out.println("selectByCustomerID error");
        }
        finally{
            JDBC.closeConnection();
        }
        return null;
    }
   
}
