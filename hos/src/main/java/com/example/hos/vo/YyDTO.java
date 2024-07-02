package com.example.hos.vo;

import com.example.hos.entity.Doctor;
import com.example.hos.entity.Yycount;

import java.util.Date;
import java.util.List;

public class YyDTO {
    private Doctor doctor;
    private List<YycountDTO> yycounts;

    @Override
    public String toString() {
        return "YyDTO{" +
                "doctor=" + doctor +
                ", yycounts=" + yycounts +
                '}';
    }

    public List<YycountDTO> getYycounts() {
        return yycounts;
    }

    public void setYycounts(List<YycountDTO> yycounts) {
        this.yycounts = yycounts;
    }

    public YyDTO(Doctor doctor, List<YycountDTO> yycounts){
        this.doctor = doctor;
        this.yycounts = yycounts;
    }
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


}
