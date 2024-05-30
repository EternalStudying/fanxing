package com.fanxing.user.mapper;

import com.fanxing.model.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(User user);

    User select(String username);
}
