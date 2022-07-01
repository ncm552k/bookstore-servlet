/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.orderDAO;

import java.util.ArrayList;
import model.order.Cash;
import model.order.Check;
import model.order.Credit;
import model.order.Payment;

/**
 *
 * @author vuvin
 */
public interface PaymentDAO {
    public int addPayment(Payment payment);
    public int updatePayment(Payment payment);
    public int deletePayment(Payment payment);
    public int deletePaymentByOrderID(int orderID);
    public ArrayList<Payment> findPaymentByOrderID(int orderID);
    public ArrayList<Payment> findAll();       

    public Payment getPayment(int paymentID);
    public Payment getPaymentByOrderID(int orderID);
}
