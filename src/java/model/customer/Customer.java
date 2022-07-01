package model.customer;

import java.io.Serializable;
import model.*;

public class Customer implements Serializable {
    private int id;
    private String phone;
    private FullName fullName;
    private Address address;
    private Account account;

    public Customer() {
    }

    public Customer(String phone) {
        this.phone = phone;
    }

    public Customer(int id, String phone) {
        this.id = id;
        this.phone = phone;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
}
