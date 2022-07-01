/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.orderDAO;

import bussiness.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.order.Shipment;

/**
 *
 * @author vuvin
 */
public class ShipmentDAOImplement implements ShipmentDAO {

    @Override
    public int addShipment(Shipment shipment) {
        String sql = "INSERT INTO Shipment(PaymentID,OrderID,Selectship,CodeShip,Address) VALUES(?,?,?,?,?)";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shipment.getPaymentID());
            preparedStatement.setInt(2, shipment.getOrderID());
            preparedStatement.setString(3, shipment.getSelectShip());
            preparedStatement.setString(4, shipment.getCodeShip());
            preparedStatement.setString(5, shipment.getAddress());
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
    public int updateShipment(Shipment shipment) {
        String sql = "UPDATE  Shipment SET Selectship=?,CodeShip=?,Address=? WHERE ID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, shipment.getSelectShip());
            preparedStatement.setString(2, shipment.getCodeShip());
            preparedStatement.setString(3, shipment.getAddress());
            preparedStatement.setInt(4, shipment.getID());
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
    public int deleteShipment(int shipmentID) {
        String sql = "DELETE FROM  Shipment WHERE ID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shipmentID);
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
    public int deleteShipmentByOrderID(int orderID) {
        String sql = "DELETE FROM  Shipment WHERE OrderID=?";
        Connection connection = JDBC.getConnection();
        int row = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderID);
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Update accout error");
            e.addSuppressed(e);
        } finally {
            JDBC.closeConnection();
            return row;
        }
    }

    @Override
    public ArrayList<Shipment> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Shipment getShipment(int shipmentID) {
        String sql = "SELECT * FROM Shipment WHERE ID=?";
        Connection connection = JDBC.getConnection();
        Shipment shipment = new Shipment();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, shipmentID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                shipment = new Shipment(resultSet.getInt("ID"), resultSet.getString("CodeShip"),
                         resultSet.getString("SelectShip"), resultSet.getString("Address"),
                         resultSet.getInt("PaymentID"), resultSet.getInt("OrderID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
        }
        return shipment;
    }

    @Override
    public Shipment getShipmentByOrderID(int orderID) {
        String sql = "SELECT * FROM Shipment WHERE OrderID=?";
        Connection connection = JDBC.getConnection();
        Shipment shipment = new Shipment();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                shipment = new Shipment(resultSet.getInt("ID"), resultSet.getString("CodeShip"),
                         resultSet.getString("SelectShip"), resultSet.getString("Address"),
                         resultSet.getInt("PaymentID"), resultSet.getInt("OrderID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.closeConnection();
        }
        return shipment;
    }
}


