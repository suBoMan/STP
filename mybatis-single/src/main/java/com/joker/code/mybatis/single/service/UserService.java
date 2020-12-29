package com.joker.code.mybatis.single.service;

import com.joker.code.mybatis.single.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
}
