package com.example.hos.vo;

import com.example.hos.entity.Yyrecord;

import java.util.List;

public class CreditDTO {
    private Integer score;
    private List<ListcreDTO> list;
//    构造函数
    public CreditDTO(Integer score,List<ListcreDTO> list){
        this.score = score;
        this.list = list;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<ListcreDTO> getList() {
        return list;
    }

    public void setList(List<ListcreDTO> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CreditDTO{" +
                "score=" + score +
                ", list=" + list +
                '}';
    }
}
