package com.europa.mybatis.mapper;

import com.europa.mybatis.entity.User;

public interface UserMapper {

    User selectUser(Long id);
}
