/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.orderDAO;

import java.util.ArrayList;
import model.order.Shipment;

/**
 *
 * @author vuvin
 */
public interface ShipmentDAO {
    public int addShipment(Shipment shipment);
    public int updateShipment(Shipment shipment);
    public int deleteShipment(int shipmentID);
    public int deleteShipmentByOrderID(int orderID);
    public ArrayList<Shipment> findAll();// bỏ      

    public Shipment getShipment(int shipmentID);

    public Shipment getShipmentByOrderID(int orderID);
}
