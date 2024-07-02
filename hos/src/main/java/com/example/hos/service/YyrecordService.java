package com.example.hos.service;

import com.example.hos.entity.Yyrecord;
import com.example.hos.vo.CreditDTO;
import com.example.hos.vo.RecordDTO;

import java.util.List;

public interface YyrecordService {
    CreditDTO getrecordcredit(Integer uid);
    Integer insertRecord(Integer uid,Integer yyid);
    List<RecordDTO> getrecordByUid(Integer uid);
    Integer updateYonCtext(String canceltext,Integer yid);
    public void checkAppointments();
}
