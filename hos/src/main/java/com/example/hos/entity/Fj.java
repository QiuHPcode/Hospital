package com.example.hos.entity;

import java.util.Date;

public class Fj {
    private Integer id;
    private Integer uid;
    private Date dd;

    @Override
    public String toString() {
        return "Fj{" +
                "id=" + id +
                ", uid=" + uid +
                ", dd=" + dd +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getDd() {
        return dd;
    }

    public void setDd(Date dd) {
        this.dd = dd;
    }
}
