package com.example.hos.vo;

import com.example.hos.entity.Doctor;
import com.example.hos.entity.Hyq;
import com.example.hos.entity.Partment;

import java.util.List;

public class DocDTO {
    private Integer hid;
    private String hname;
    private Integer pmid;
    private String pname;
    private Integer did;
    private String dname;
    private Integer sex;
    private String specialty;
    private String jt;


    public DocDTO(Hyq hyq,Partment partment,Doctor doctor){
        this.hid = hyq.getHid();
        this.hname = hyq.getHname();
        this.pmid = partment.getPmid();
        this.pname = partment.getPname();
        this.did = doctor.getDid();
        this.dname = doctor.getDname();
        this.sex = doctor.getGender();
        this.specialty = doctor.getSpecialty();
        this.jt = doctor.getJt();
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

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getJt() {
        return jt;
    }

    public void setJt(String jt) {
        this.jt = jt;
    }
}
