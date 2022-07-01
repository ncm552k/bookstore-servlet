package model.customer;

import java.io.Serializable;
import model.*;

public class Account implements Serializable {
    private int id;
    private String user;
    private String password;
    private int customerID;

    public Account() {
    }

    public Account(String user, String password, int customerID) {
        this.user = user;
        this.password = password;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    
}
