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

    @Column(name = "STATUS")
    private String status;

    public Equipment() {
    }

    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
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
