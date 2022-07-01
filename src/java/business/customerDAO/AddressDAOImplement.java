package business.customerDAO;

import bussiness.JDBC;
import model.customer.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddressDAOImplement implements AddressDAO{
    
    public  void addAddress(Address address){
        String sql = "INSERT INTO Address(Number,Street,District,City,Country,CustomerId) VALUES(?,?,?,?,?,?)";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,address.getNumber());
            preparedStatement.setString(2,address.getStreet());
            preparedStatement.setString(3,address.getDistrict());
            preparedStatement.setString(4,address.getCity());
            preparedStatement.setString(5,address.getCountry());
            preparedStatement.setInt(6,address.getCustomerID());
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("addAddress error");
        }
        finally{
            JDBC.closeConnection();
        }
    }
    
    public  void updateAddress(Address address){
        String sql = "UPDATE  Address  SET Number=?,Street=?,District=?,City=?,Country=? WHERE CustomerId=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,address.getNumber());
            preparedStatement.setString(2,address.getStreet());
            preparedStatement.setString(3,address.getDistrict());
            preparedStatement.setString(4,address.getCity());
            preparedStatement.setString(5,address.getCountry());
            preparedStatement.setInt(6,address.getCustomerID());
            preparedStatement.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println("updateAddress error");
        }
        finally{
            JDBC.closeConnection();
        }
    }
    
    public  Address selectByIDCustomer(int customerId){
        String sql="SELECT * FROM Address WHERE CustomerId=?";
        Connection connection=JDBC.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                String number=resultSet.getString("number");
                String street=resultSet.getString("street");
                String district=resultSet.getString("district");
                String city=resultSet.getString("city");
                String country=resultSet.getString("country");
                int customerID=resultSet.getInt("CustomerId");
                int id=resultSet.getInt("ID");
                Address address=new Address(number, street, district, city, country, customerID);
                address.setId(id);
                return address;
            }
        } catch (Exception e) {
        }
        finally{
            JDBC.closeConnection();
        }
        return null;
    }
    
}
