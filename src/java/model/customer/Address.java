package model.customer;

import java.io.Serializable;
import model.*;

public class Address implements Serializable {
    private int id;
    private String number;
    private String street;
    private String district;
    private String city;
    private String country;
    private int customerID;

    public Address() {
    }

    public Address(String number, String street, String district, String city, String country, int customerID) {
        this.number = number;
        this.street = street;
        this.district = district;
        this.city = city;
        this.country = country;
        this.customerID = customerID;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
}
