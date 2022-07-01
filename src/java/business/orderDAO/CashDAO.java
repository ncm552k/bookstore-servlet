/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.orderDAO;

import java.util.ArrayList;
import model.order.Cash;

/**
 *
 * @author vuvin
 */
public interface CashDAO {
    public int addCash(Cash cash);
    public int updateCash(Cash cash);
    public int deleteCash(int cashID);
    public ArrayList<Cash> findAll();
}
