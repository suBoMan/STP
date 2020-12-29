package com.joker.code.mybatis.single.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private Long id; // 编号
    private String username; // 用户名
    private String password; // 密码
}
