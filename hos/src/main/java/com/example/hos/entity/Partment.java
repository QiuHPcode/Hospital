package com.example.hos.entity;

public class Partment {
    private Integer pmid;
    private String pname;
    private Integer hid;

    @Override
    public String toString() {
        return "Partment{" +
                "pmid=" + pmid +
                ", pname='" + pname + '\'' +
                ", hid=" + hid +
                '}';
    }

    public Integer getPmid() {
        return pmid;
    }

    public void setPmid(Integer pmid) {
        this.pmid = pmid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }
}
