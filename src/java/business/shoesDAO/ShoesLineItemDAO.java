/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.shoesDAO;

import business.shoesDAO.*;
import java.util.ArrayList;
import model.shoes.ShoesLineItem;
import model.order.Cart;

/**
 *
 * @author vuvin
 */
public interface ShoesLineItemDAO {
        public int updateShoesLineItem(ShoesLineItem shoesLineItem);
    public ArrayList<ShoesLineItem> findShoesLineItemByCartID(int  cartID);

    public int deleteByCartID(int cartID);
    public int deleteByShoesItemID(int shoesItemID);
    public int deleteShoesLineItem(ShoesLineItem shoesLineItem);
}
