package com.tw.core;

import javax.persistence.*;

/**
 * Created by twer on 7/16/14.
 */
@Entity
@Table(name = "Course")
public class Course {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SEQ")
    private String seq;

    @Column(name = "COACH")
    private String coach;

    public String getCoach() {
        return coach;
    }

    public Course() {
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getSeq() {
        return seq;
    }
    public void setSeq(String seq) {
        this.seq = seq;
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
