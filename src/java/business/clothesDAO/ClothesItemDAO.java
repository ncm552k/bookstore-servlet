/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.clothesDAO;

import business.clothesDAO.*;
import java.util.List;
import model.clothes.ClothesItem;

/**
 *
 * @author vuvin
 */
public interface ClothesItemDAO {
    public ClothesItem getClothesItem(int clothesItemID);
    public List<ClothesItem> findAll();
    public List<ClothesItem> searchClothesItem(String title);
}
