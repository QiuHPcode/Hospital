package com.example.hos.mapper;

import com.example.hos.entity.Yyrecord;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface YyrecordMapper {
    @Select("select * from yyrecord where uid=#{uid} and yon=2")
    List<Yyrecord> getRecordByUid1(Integer uid);

    @Select("select * from yyrecord where uid=#{uid}")
    List<Yyrecord> getAllRecord(Integer uid);

    @Insert("insert into yyrecord (uid,did,daytime,infotime,yon,sc) VALUES(#{uid},#{did},#{daytime},#{infotime},3,0)")
    Integer insertRecord(Integer uid, Integer did, Date daytime,Integer infotime);

    @Select("select * from yyrecord where uid=#{uid} and daytime=#{daytime} and yon = 3")
    List<Yyrecord> getAnyDaytimeAndDid(Integer uid, Date daytime);

    @Select("select * from yyrecord where uid=#{uid}")
    List<Yyrecord> getRecordByUid(Integer uid);

    @Update("update yyrecord set yon = 4,canceltext=#{canceltext} where yid=#{yid}")
    Integer updateYonCtext(String canceltext,Integer yid);

    @Select("select * from yyrecord where yon = 3 and daytime <curdate()")
    List<Yyrecord> selectOvertimerecordAfter();

    @Select("select * from yyrecord where ((daytime = curdate() and infotime =1) or (daytime < curdate())) and yon =3")
    List<Yyrecord> selectOvertimerecordBefore();

    @Update("update yyrecord set yon =2,sc=-10 where yid=#{yid}")
    Integer updateDisable(Integer yid);

    @Select("select * from yyrecord where yid=#{yid}")
    Yyrecord getRecordByYid(Integer yid);
}
