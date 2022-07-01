/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.orderDAO;

import java.util.ArrayList;
import model.order.Cart;
import model.order.Order;

/**
 *
 * @author vuvin
 */
public interface OrderDAO {
    public int addOrder(Order order);
    public int updateOrder(Order order);
    public int deleteOrder(int orderID);
    public Order getOrder(int orderID);
    public ArrayList<Order> findOrderByCartID(int cartID);
    public ArrayList<Order> findAll();     
    public ArrayList<Order> findOrderByCustomerID(int customerID);
}
