package com.example.hos.entity;

import java.util.Date;

public class Yycount {
    private Integer yyid;
    private Integer did;
    private Date daytime;
    private Integer infotime;
    private Integer people;

    public Integer getYyid() {
        return yyid;
    }

    public void setYyid(Integer yyid) {
        this.yyid = yyid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Date getDaytime() {
        return daytime;
    }

    public void setDaytime(Date daytime) {
        this.daytime = daytime;
    }

    public Integer getInfotime() {
        return infotime;
    }

    public void setInfotime(Integer infotime) {
        this.infotime = infotime;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Yycount{" +
                "yyid=" + yyid +
                ", did=" + did +
                ", daytime=" + daytime +
                ", infotime=" + infotime +
                ", people=" + people +
                '}';
    }
}
