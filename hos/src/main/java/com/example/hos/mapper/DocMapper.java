package com.example.hos.mapper;


import com.example.hos.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DocMapper {
    @Select("select * from doctor where pmid = #{pmid}")
    List<Doctor> getDocsByPmid(Integer pmid);
    @Select("select * from doctor where did =#{did}")
    Doctor getDocByDid(Integer did);
    @Select("select * from doctor")
    List<Doctor> getAlldoc();
}
