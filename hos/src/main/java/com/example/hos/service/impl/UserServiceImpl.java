package com.example.hos.service.impl;

import com.example.hos.entity.User;
import com.example.hos.mapper.UserMapper;
import com.example.hos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserByUid(Integer uid) {
        return userMapper.queryUserByUid(uid);
    }

    @Override
    public Integer insertUser(User user) {
        int i= userMapper.insertUser(user);
        System.out.println(user.getUid());
        return i;
    }

    @Override
    public Integer updateUser(User user) {
        int i= userMapper.updateUser(user);
        System.out.println(user.getUid());
        return i;
    }

    @Override
    public Integer deleteUser(Integer uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public User loginVal(String ph, String pw) {
        User user = userMapper.findUserByPhone(ph);
        if(user != null && user.getPw().equals(pw)){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public boolean queryUserByPh(String ph) {
        User user = userMapper.queryUserByPh(ph);
        return user == null;
    }

    @Override
    public boolean queryUserByIden(String iden) {
        User user = userMapper.queryUserByIden(iden);
        return user == null;
    }
}
