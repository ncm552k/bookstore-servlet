/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.electronicsDAO;

import business.electronicsDAO.*;
import java.util.ArrayList;
import model.electronics.ElectronicsLineItem;
import model.order.Cart;

/**
 *
 * @author vuvin
 */
public interface ElectronicsLineItemDAO {

    public int updateElectronicsLineItem(ElectronicsLineItem electronicsLineItem);

    public ArrayList<ElectronicsLineItem> findElectronicsLineItemByCartID(int cartID);

    public int deleteByCartID(int cartID);
    public int deleteByElectronicsItemID(int electronics);
    public int deleteElectronicsLineItem(ElectronicsLineItem electronicsLineItem);
}
