package com.example.hos.mapper;

import com.example.hos.entity.Hyq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HyqMapper {
    @Select("select * from hyq")
    List<Hyq> getAllHyq();

    @Select("select * from hyq where hid = #{hid}")
    Hyq getHyqByHid(Integer hid);
}
