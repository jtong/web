package com.tw.core;

import javax.persistence.*;
import java.lang.String;
import java.sql.Date;

/**
 * Created by twer on 7/16/14.
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "AGE")
    private int age;

    @Column(name = "GRENDER")
    private boolean grender;

    @Column(name = "SEQ")
    private String seq;

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    @Column(name = "COACH")
    private String coach;

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Column(name = "EXPIRE")
    private Date expire;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
    public Customer() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public boolean isGrender() {
        return grender;
    }

    public void setGrender(boolean grender) {
        this.grender = grender;
    }

}
