package com.example.hos.vo;

import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;

import java.util.List;

public class HlDTO {
    private Integer hid;
    private String hname;
    private List<Partment> partments;

    public HlDTO(Hyq hyq, List<Partment> partments){
        this.hid = hyq.getHid();
        this.hname = hyq.getHname();
        this.partments = partments;
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

    public List<Partment> getPartments() {
        return partments;
    }

    public void setPartments(List<Partment> partments) {
        this.partments = partments;
    }
}
