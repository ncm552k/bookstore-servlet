/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author vuvin
 */
public class Credit extends Payment implements Serializable{
    private String number;
    private String type;
    private Date expDate;

    public Credit() {
    }

    public Credit(String number, String type, Date expDate) {
        this.number = number;
        this.type = type;
        this.expDate = expDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
    
}
