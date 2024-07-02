package com.example.hos.mapper;

import com.example.hos.entity.Yycount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface YycountMapper {
    @Select("select * from yycount where did=#{did} and daytime between curdate() + interval 1 day and curdate() + interval 3 day order by daytime asc")
    List<Yycount> getyydocByDid(Integer did);

    @Select("select * from yycount where yyid=#{yyid}")
    Yycount getYycountByYyid(Integer yyid);

    @Select("select people from yycount where yyid=#{yyid}")
    Integer getPeopleByYyid(Integer yyid);

    @Update("update yycount set people =#{people} where yyid =#{yyid}")
    Integer updatePeople(Integer people,Integer yyid);

}
