package com.example.hos.mapper;


import com.example.hos.entity.Partment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PmMapper {
    @Select("select * from pm")
    List<Partment> getAllpm();

    @Select("select * from pm where hid = #{hid}")
    List<Partment> getpmBYHid(Integer hid);

    @Select("select * from pm where pmid = #{pmid}")
    Partment getpmBYPid(Integer pmid);
}
