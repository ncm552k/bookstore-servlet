/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.book;

/**
 *
 * @author Admin
 */
public class Author {
    private int ID;
    private String name;
    private String biography;

    public Author() {
    }

    public Author(int ID, String name, String biography) {
        this.ID = ID;
        this.name = name;
        this.biography = biography;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" + "ID=" + ID + ", name=" + name + ", biography=" + biography + '}';
    }
    
    
}
