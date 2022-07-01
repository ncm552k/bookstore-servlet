/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.orderDAO;

import java.util.ArrayList;
import model.order.Check;

/**
 *
 * @author vuvin
 */
public interface CheckDAO {
    public int addCheck(Check check);
    public int updateCheck(Check check);
    public int deleteCheck(int checkID);
    public ArrayList<Check> findAll(); 
}
