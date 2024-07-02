package com.example.hos.service;

import com.example.hos.entity.User;

import java.util.List;

public interface UserService {

    List<User> queryAllUser();
    User queryUserByUid(Integer uid);
    Integer insertUser(User user);
    Integer updateUser(User user);
    Integer deleteUser(Integer uid);
    User loginVal(String ph, String pw);
    boolean queryUserByPh(String ph);
    boolean queryUserByIden(String iden);


}
