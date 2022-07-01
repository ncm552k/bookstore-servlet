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
public class Cash extends Payment implements Serializable {
    private float cashTendered;

    public Cash() {
    }

    public Cash(float cashTendered) {
        super();
        this.cashTendered = cashTendered;
    }

    public float getCashTendered() {
        return cashTendered;
    }

    public void setCashTendered(float cashTendered) {
        this.cashTendered = cashTendered;
    }
    
}
