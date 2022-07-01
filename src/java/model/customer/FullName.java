package model.customer;

import java.io.Serializable;
import model.*;

public class FullName implements Serializable {
    private int id;
    private String fullName;
    private String lastName;
    private String firstName;
    private int customerID;

    public FullName() {
    }

    public FullName(String fullName, String lastName, String firstName, int customerID) {
        this.fullName = fullName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.customerID = customerID;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    
}
