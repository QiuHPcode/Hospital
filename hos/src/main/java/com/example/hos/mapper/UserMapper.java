package com.example.hos.mapper;

import com.example.hos.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> queryAllUser();

    @Select("select * from user where uid=#{uid}")
    User queryUserByUid(Integer uid);

    @Select("select * from user where ph=#{ph}")
    User queryUserByPh(String ph);

    @Select("select * from user where iden=#{iden}")
    User queryUserByIden(String iden);

    @Insert("insert into user( name,sex, iden, ph, pw,score) VALUES(#{name},#{sex},#{iden},#{ph},#{pw},100)")
    @Options(useGeneratedKeys = true,keyProperty = "uid")
    Integer insertUser(User user);

    @Update("update user set pw=#{pw} where uid =#{uid}")
    Integer updateUser(User user);

    @Delete("delete from user where uid = #{uid}")
    Integer deleteUser(Integer uid);

    @Select("select * from user where ph=#{ph}")
    User findUserByPhone(String ph);

    @Update("update user set score=score+#{sc} where uid =#{uid}")
    Integer updateUserSco(Integer sc,Integer uid);
}
