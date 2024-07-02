package com.example.hos.vo;


import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;

import java.util.List;

public class ListYy {
    private String hname;
    private String pname;
    private List<YyDTO> doc;

    public ListYy(Hyq hyq, Partment partment,List<YyDTO> yydto){
        this.hname = hyq.getHname();
        this.pname = partment.getPname();
        this.doc = yydto;

    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<YyDTO> getDoc() {
        return doc;
    }

    public void setDoc(List<YyDTO> doc) {
        this.doc = doc;
    }

    @Override
    public String toString() {
        return "ListYy{" +
                "hname='" + hname + '\'' +
                ", pname='" + pname + '\'' +
                ", doc=" + doc +
                '}';
    }
}
