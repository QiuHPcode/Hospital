package com.example.hos.vo;

import com.example.hos.entity.User;


public class UserDTO {
    private Integer uid;
    private String name;
    private Integer score;
    private Integer sex;
    private String ph;
    private String iden;



    public UserDTO(User user) {
        this.uid = user.getUid();
        this.name = user.getName();
        this.score = user.getScore();
        this.sex = user.getSex();
        this.ph = user.getPh().substring(0,3)+"****"+user.getPh().substring(7,user.getPh().length());
        this.iden = user.getIden().substring(0,3)+"***********"+user.getIden().substring(14,user.getIden().length());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }


}
