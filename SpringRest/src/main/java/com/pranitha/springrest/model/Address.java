package com.pranitha.springrest.model;

import javax.persistence.*;

/**
 * Created by naveen on 2/4/16.
 */

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int addressId;
    private int customerId;
    private String city;
    private String State;
    private int zipcode;

    @JoinColumn(name="customerId")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }


    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", State='" + State + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressId != address.addressId) return false;
        if (zipcode != address.zipcode) return false;
        if (!city.equals(address.city)) return false;
        return State.equals(address.State);

    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + city.hashCode();
        result = 31 * result + State.hashCode();
        result = 31 * result + zipcode;
        return result;
    }
}
