package com.example.hos.vo;

import com.example.hos.entity.Doctor;
import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;
import com.example.hos.entity.Yyrecord;

import static com.example.hos.util.date.DateUtils.formatDate;

public class ListcreDTO {
    private String daytime;
    private Integer infotime;
    private String hname;
    private String pname;
    private String dname;
    private String jt;
    private Integer sc;



    public ListcreDTO(Yyrecord yyrecord, Hyq hyq, Partment partment, Doctor doctor){
        this.daytime = formatDate(yyrecord.getDaytime());
        this.infotime = yyrecord.getInfotime();
        this.hname = hyq.getHname();
        this.pname = partment.getPname();
        this.dname = doctor.getDname();
        this.jt = doctor.getJt();
        this.sc =yyrecord.getSc();
    }

    public String getDaytime() {
        return daytime;
    }
    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public Integer getInfotime() {
        return infotime;
    }

    public void setInfotime(Integer infotime) {
        this.infotime = infotime;
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

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJt() {
        return jt;
    }

    public void setJt(String jt) {
        this.jt = jt;
    }

    public Integer getSc() {
        return sc;
    }

    public void setSc(Integer sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "ListcreDTO{" +
                "daytime='" + daytime + '\'' +
                ", infotime=" + infotime +
                ", hname='" + hname + '\'' +
                ", pname='" + pname + '\'' +
                ", dname='" + dname + '\'' +
                ", jt='" + jt + '\'' +
                ", sc=" + sc +
                '}';
    }
}
