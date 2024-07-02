package com.example.hos.vo;

import com.example.hos.entity.Doctor;
import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;
import com.example.hos.entity.Yyrecord;

import static com.example.hos.util.date.DateUtils.formatDate;

public class RecordDTO {
    private Integer yid;
    private Doctor doc;
    private Integer pmid;
    private String pname;
    private Integer hid;
    private String hname;
    private String daytime;
    private Integer infotime;
    private Integer yon;
    private String canceltext;


    public RecordDTO(Yyrecord yyrecord, Doctor doctor, Partment partment, Hyq hyq){
        this.yid = yyrecord.getYid();
        this.doc = doctor;
        this.pmid = partment.getPmid();
        this.pname = partment.getPname();
        this.hid = hyq.getHid();
        this.hname= hyq.getHname();
        this.daytime = formatDate(yyrecord.getDaytime());
        this.infotime = yyrecord.getInfotime();
        this.yon = yyrecord.getYon();
        this.canceltext = yyrecord.getCanceltext();
    }

    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    @Override
    public String toString() {
        return "RecordDTO{" +
                "yid=" + yid +
                ", doc=" + doc +
                ", pmid=" + pmid +
                ", pname='" + pname + '\'' +
                ", hid=" + hid +
                ", hname='" + hname + '\'' +
                ", daytime='" + daytime + '\'' +
                ", infotime=" + infotime +
                ", yon=" + yon +
                ", canceltext='" + canceltext + '\'' +
                '}';
    }

    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
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

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
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

    public Integer getYon() {
        return yon;
    }

    public void setYon(Integer yon) {
        this.yon = yon;
    }

    public String getCanceltext() {
        return canceltext;
    }

    public void setCanceltext(String canceltext) {
        this.canceltext = canceltext;
    }
}
