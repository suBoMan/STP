package com.joker.code.mybatis.single.service.impl;

import com.joker.code.mybatis.single.entity.User;
import com.joker.code.mybatis.single.mapper.UserMapper;
import com.joker.code.mybatis.single.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
