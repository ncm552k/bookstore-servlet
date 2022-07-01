/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.order;

import java.io.Serializable;

/**
 *
 * @author vuvin
 */
public class Check extends Payment implements Serializable{
    private String name;
    private String bankID;
    
    public Check() {
    }

    public Check(String name, String bankID) {
        this.name = name;
        this.bankID = bankID;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }


    
}
