package com.joker.code.mybatis.single.mapper;

import com.joker.code.mybatis.single.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();
}
