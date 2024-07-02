package com.example.hos.vo;

import com.example.hos.entity.Yycount;

import static com.example.hos.util.date.DateUtils.formatDate;

public class YycountDTO {
    private Integer yyid;
    private String daytime;
    private Integer infotime;
    private Integer people;
    public YycountDTO(Yycount yycount){
        this.yyid = yycount.getYyid();
        this.daytime = formatDate(yycount.getDaytime());
        this.infotime = yycount.getInfotime();
        this.people = yycount.getPeople();
    }

    public Integer getYyid() {
        return yyid;
    }

    public void setYyid(Integer yyid) {
        this.yyid = yyid;
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

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "YycountDTO{" +
                "yyid=" + yyid +
                ", daytime='" + daytime + '\'' +
                ", infotime=" + infotime +
                ", people=" + people +
                '}';
    }
}
