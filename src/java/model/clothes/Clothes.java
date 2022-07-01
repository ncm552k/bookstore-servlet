/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.clothes;

/**
 *
 * @author Admin
 */
public class Clothes {
    private int ID;
    private String name;
    private String type;
    private String material;
    private String gender;
    private String brand;
    private String color;
    private String size;
    private String img;

    public Clothes() {
    }

    public Clothes(int ID, String name, String type, String material, String gender, String brand, String color, String size, String img) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.material = material;
        this.gender = gender;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.img = img;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
            
}
