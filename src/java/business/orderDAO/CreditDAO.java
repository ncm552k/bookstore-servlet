/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.orderDAO;

import java.util.ArrayList;
import model.order.Credit;

/**
 *
 * @author vuvin
 */
public interface CreditDAO {
    public int addCredit(Credit credit);
    public int updateCredit(Credit credit);
    public int deleteCredit(int creditID);
    public ArrayList<Credit> findAll();     
}
