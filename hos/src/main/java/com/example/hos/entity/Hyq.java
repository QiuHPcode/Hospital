package com.example.hos.entity;

//院区
public class Hyq {
    private Integer hid;
    private String hname;
    private String hloc;
    private String hpo;
    private String info;
    private String device;

    @Override
    public String toString() {
        return "Hyq{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", hloc='" + hloc + '\'' +
                ", hpo='" + hpo + '\'' +
                ", info='" + info + '\'' +
                ", device='" + device + '\'' +
                '}';
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHloc() {
        return hloc;
    }

    public void setHloc(String hloc) {
        this.hloc = hloc;
    }

    public String getHpo() {
        return hpo;
    }

    public void setHpo(String hpo) {
        this.hpo = hpo;
    }

}
