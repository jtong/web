package com.tw.core;

import javax.persistence.*;
import java.lang.String;

/**
 * Created by twer on 7/16/14.
 */
@Entity
@Table(name = "Equipment")
public class Equipment {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    public Equipment() {
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
