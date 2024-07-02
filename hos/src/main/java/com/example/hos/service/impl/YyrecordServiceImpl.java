package com.example.hos.service.impl;

import com.example.hos.entity.*;
import com.example.hos.mapper.*;
import com.example.hos.service.YyrecordService;
import com.example.hos.vo.CreditDTO;
import com.example.hos.vo.ListcreDTO;
import com.example.hos.vo.RecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class YyrecordServiceImpl implements YyrecordService {

    @Autowired
    private YyrecordMapper yyrecordMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HyqMapper hyqMapper;
    @Autowired
    private PmMapper pmMapper;
    @Autowired
    private DocMapper docMapper;


    @Override
    public CreditDTO getrecordcredit(Integer uid) {
        User user = userMapper.queryUserByUid(uid);
        Integer score = user.getScore();
        List<ListcreDTO> list = new ArrayList<>();
        List<Yyrecord> record = yyrecordMapper.getRecordByUid1(uid);
        record.sort((r1, r2) -> r2.getDaytime().compareTo(r1.getDaytime()));
        for (Yyrecord yyrecord : record){
            Integer did = yyrecord.getDid();
            Doctor doc = docMapper.getDocByDid(did);
            Partment partment = pmMapper.getpmBYPid(doc.getPmid());
            Hyq hyq = hyqMapper.getHyqByHid(doc.getHid());
            ListcreDTO listcreDTO = new ListcreDTO(yyrecord,hyq,partment,doc);
            list.add(listcreDTO);
        }
        return new CreditDTO(score,list);
    }
    @Autowired
    private YycountMapper yycountMapper;

    @Override
    public Integer insertRecord(Integer uid, Integer yyid) {
        Integer people = yycountMapper.getPeopleByYyid(yyid);
        if(people == 0){
            //此医生预约人数满
            return 0;
        }else {
            Yycount yycount = yycountMapper.getYycountByYyid(yyid);
            //验证当天此科室是否预约过
            Doctor doc = docMapper.getDocByDid(yycount.getDid());
            Integer pmid1 = doc.getPmid();
            List<Yyrecord> anyDaytimeAndDid = yyrecordMapper.getAnyDaytimeAndDid(uid,yycount.getDaytime());
            for (Yyrecord yyrecord:anyDaytimeAndDid){
                Integer pmid = docMapper.getDocByDid(yyrecord.getDid()).getPmid();
                if(pmid1.equals(pmid)){
                    //当天用户在此医院此科室预约过
                    return 2;
                }
            }
            Integer integer = yycountMapper.updatePeople(people - 1, yyid);
            if(integer ==1){

                System.out.println(yycount.getDaytime());
                Integer integer1 = yyrecordMapper.insertRecord(uid, yycount.getDid(), yycount.getDaytime(), yycount.getInfotime());
                if(integer1==1){
                    //预约成功
                    return 1;
                }
            }
            //插入失败 .基本不会出现
            return -1;

        }

    }

    @Override
    public List<RecordDTO> getrecordByUid(Integer uid) {
        List<Yyrecord> record = yyrecordMapper.getRecordByUid(uid);
        record.sort((r1, r2) -> r2.getDaytime().compareTo(r1.getDaytime()));
        List<RecordDTO> list = new ArrayList<>();
        for(Yyrecord yyrecord:record){
            Doctor doc = docMapper.getDocByDid(yyrecord.getDid());
            Partment partment = pmMapper.getpmBYPid(doc.getPmid());
            Hyq hyq = hyqMapper.getHyqByHid(doc.getHid());
            RecordDTO recordDTO = new RecordDTO(yyrecord, doc, partment, hyq);
            list.add(recordDTO);
        }
        return list;
    }

    @Override
    public Integer updateYonCtext(String canceltext, Integer yid) {
        Integer yonCtext = yyrecordMapper.updateYonCtext(canceltext, yid);
        if(yonCtext ==1){
            System.out.println("更新完成");
            return 1;
        }else {
            return 0;
        }
    }
//定时任务



    @Scheduled(cron = "0 0 0,12 * * ?") // 每天午夜,中午执行
    @Override
    public void checkAppointments() {
        LocalDateTime currentTime = LocalDateTime.now();
        List<Yyrecord> yyrecords;
        if(currentTime.getHour() <12){
//            下午
            yyrecords = yyrecordMapper.selectOvertimerecordAfter();
        }else {
            //上午
            yyrecords = yyrecordMapper.selectOvertimerecordBefore();
        }
        for(Yyrecord yyrecord:yyrecords){
            Integer disable = yyrecordMapper.updateDisable(yyrecord.getYid());
            User user = userMapper.queryUserByUid(yyrecord.getUid());
            yyrecord.setSc(-10);
            updateUserScore(yyrecord,user);
        }
    }

    private void updateUserScore(Yyrecord yyrecord, User user) {
        Integer score = yyrecord.getSc();
        int newScore = user.getScore() + (int)score;
        if (newScore < 0) {
            score = -user.getScore(); // 确保用户分数不会变为负数
        }
        Integer updateResult = userMapper.updateUserSco(score, user.getUid());

    }
}
