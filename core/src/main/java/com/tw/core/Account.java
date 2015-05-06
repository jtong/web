package com.tw.core;

import javax.persistence.*;
import java.lang.String;

/**
 * Created by twer on 7/16/14.
 */
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "PAID_TIME")
    private double paidTime;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(double paidTime) {
        this.paidTime = paidTime;
    }

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
