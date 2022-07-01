/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.clothesDAO;

import java.util.ArrayList;
import model.clothes.ClothesLineItem;
import model.order.Cart;


/**
 *
 * @author vuvin
 */
public interface ClothesLineItemDAO {
    public int updateClothesLineItem(ClothesLineItem clothesLineItem);
    public ArrayList<ClothesLineItem> findClothesLineItemByCartID(int  cartID);
    public int deleteByCartID(int cartID);
    public int deleteByClothesItemID(int ClothesItemID);
    public int deleteClothesLineItem(ClothesLineItem clothesLineItem);
    public void addClothesLineItem(ClothesLineItem clothesLineItem);
}
