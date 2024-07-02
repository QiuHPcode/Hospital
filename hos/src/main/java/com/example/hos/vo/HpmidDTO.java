package com.example.hos.vo;

public class HpmidDTO {
    private Integer hid;
    private Integer pmid;


    public HpmidDTO(Integer hid,Integer pmid){
        this.hid = hid;
        this.pmid = pmid;
    }
    @Override
    public String toString() {
        return "HpmidDTO{" +
                "hid=" + hid +
                ", pmid=" + pmid +
                '}';
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getPmid() {
        return pmid;
    }

    public void setPmid(Integer pmid) {
        this.pmid = pmid;
    }
}
