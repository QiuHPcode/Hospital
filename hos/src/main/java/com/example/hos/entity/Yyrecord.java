package com.example.hos.entity;

import java.util.Date;

public class Yyrecord {
    Integer yid;
    Integer uid;
    Integer did;
    Date daytime;
    Integer infotime;
    Integer yon;
    String canceltext;
    Integer sc;

    @Override
    public String toString() {
        return "Yyrecord{" +
                "yid=" + yid +
                ", uid=" + uid +
                ", did=" + did +
                ", daytime=" + daytime +
                ", infotime=" + infotime +
                ", yon=" + yon +
                ", canceltext='" + canceltext + '\'' +
                ", sc=" + sc +
                '}';
    }

    public String getCanceltext() {
        return canceltext;
    }

    public void setCanceltext(String canceltext) {
        this.canceltext = canceltext;
    }



    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Integer getYon() {
        return yon;
    }

    public void setYon(Integer yon) {
        this.yon = yon;
    }

    public Integer getSc() {
        return sc;
    }

    public void setSc(Integer sc) {
        this.sc = sc;
    }
}
