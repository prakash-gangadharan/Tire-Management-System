package com.tiremanagement.orders.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;
    String cusFirstname;
    String cusLastname;
    String cusEmail;
    String cusPhoneNo;
    String cusCity;
    String cusProvince;
    String cusCountry;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "orderId")
    @JoinTable(name = "customer_order", joinColumns = {@JoinColumn(name = "customerId")}, inverseJoinColumns = {@JoinColumn(name = "orderId")})
    Set<Orders> orders = new HashSet<Orders>(0);

    public Customer(String cusFirstname, String cusLastname, String cusEmail, String cusPhoneNo, String cusCity, String cusProvince, String cusCountry, Set<Orders> orders) {
        this.cusFirstname = cusFirstname;
        this.cusLastname = cusLastname;
        this.cusEmail = cusEmail;
        this.cusPhoneNo = cusPhoneNo;
        this.cusCity = cusCity;
        this.cusProvince = cusProvince;
        this.cusCountry = cusCountry;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "customerId = " + customerId + " , cusFirstname = " + cusFirstname + " , cusLastname = " + cusLastname +
                " , cusEmail = " + cusEmail + " , cusPhoneNo = " + cusPhoneNo + " , cusCity = " + cusCity +
                ", cusProvince = " + cusProvince + " , cusCountry = " + cusCountry;
    }
}
