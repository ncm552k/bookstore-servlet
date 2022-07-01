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
import model.order.Order;
import model.order.Payment;
import model.order.Shipment;

/**
 *
 * @author vuvin
 */
public class OrderDAOImplement implements OrderDAO {

    @Override
    public int addOrder(Order order) {
        String sql = "INSERT INTO onlinestore.Order(CustomerID,CartID,Created,Status) VALUES(?,?,?,?)";
        Connection connection = JDBC.getConnection();
        int ID = -1;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getCustomerID());
            preparedStatement.setInt(2, order.getCartID());
            preparedStatement.setDate(3, order.getDate());
            preparedStatement.setString(4, order.getStatus());

            ID = preparedStatement.executeUpdate();
            connection.commit();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                ID = resultSet.getInt(1);
            }
            connection.commit();
            order.setID(ID);
            return ID;
        } catch (Exception e) {
            System.out.println("Add accout error");
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
        } finally {
            JDBC.closeConnection();
            return ID;
        }
    }

    @Override
    public int updateOrder(Order order) {
        String sql = "UPDATE  onlinestore.Order SET Created=?,Status=? WHERE ID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, order.getDate());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.setInt(3, order.getID());

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
    public int deleteOrder(int orderID) {
        //delete payment, shipment
        String sql = "DELETE FROM Shipment WHERE OrderID =?";
                
        String sql1 ="DELETE FROM  onlinestore.Order WHERE ID=?";
        Connection connection = JDBC.getConnection();
//        Payment payment = new Payment();
//        payment.setOrderID(orderID);
//        Shipment shipment = new Shipment();
//        shipment.setOrderID(orderID);
        int row = -1;
        try {
            
//            new ShipmentDAOImplement().deleteShipmentByOrderID(shipment);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderID);
            row = preparedStatement.executeUpdate();
            new PaymentDAOImplement().deletePaymentByOrderID(orderID);
//            preparedStatement.setInt(3, orderID);
//            preparedStatement.setInt(4, orderID);
//            preparedStatement.setInt(5, orderID);
//            preparedStatement.setInt(6, orderID);

            
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement1.setInt(1, orderID);
            row = preparedStatement1.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update accout error");
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public ArrayList<Order> findOrderByCartID(int cartID) {
        String sql = "SELECT * FROM onlinestore.Order WHERE CartID = ?";
        Connection connection = JDBC.getConnection();
        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cartID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order o = new Order();
                o.setID(resultSet.getInt("ID"));
                orders.add(o);

            }
            return orders;
        } catch (Exception e) {
            System.out.println("Error find Order by CartID ");
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
            return orders;
        }
    }

    @Override
    public ArrayList<Order> findAll() {
        ArrayList<Order> orders = new ArrayList<>();
        return orders;
    }

    @Override
    public ArrayList<Order> findOrderByCustomerID(int customerID) {
        String sql = "SELECT * FROM onlinestore.Order WHERE CustomerID = ?";
        Connection connection = JDBC.getConnection();
        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order o = new Order(resultSet.getInt("ID"), resultSet.getDate("Created"),
                         resultSet.getString("Status"), resultSet.getInt("CartID"),
                         resultSet.getInt("CustomerID"));

                orders.add(o);

            }
            return orders;
        } catch (Exception e) {
            System.out.println("Error find Order by CustomerID ");
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
            return orders;
        }
    }

    @Override
    public Order getOrder(int orderID) {
        String sql = "SELECT * FROM onlinestore.Order WHERE ID=?";
        Connection connection = JDBC.getConnection();
        Order orderResult = new Order();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderID);
            System.out.println(orderID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderResult = new Order(resultSet.getInt("ID"), resultSet.getDate("Created"),
                         resultSet.getString("Status"), resultSet.getInt("CartID"),
                         resultSet.getInt("CustomerID"));
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
        }
        return orderResult;
    }

}
