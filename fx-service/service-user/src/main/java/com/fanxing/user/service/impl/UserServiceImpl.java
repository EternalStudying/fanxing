package com.fanxing.user.service.impl;

import com.alibaba.fastjson2.JSON;
import com.fanxing.common.exception.FxException;
import com.fanxing.model.constant.RedisConstant;
import com.fanxing.model.dto.user.UserDto;
import com.fanxing.model.entity.user.User;
import com.fanxing.model.vo.common.ResultCodeEnum;
import com.fanxing.user.mapper.UserMapper;
import com.fanxing.user.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void register(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(DigestUtils.md5Hex(userDto.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public String login(UserDto userDto) {
        User user = userMapper.select(userDto.getUsername());
        if(user == null) throw new FxException(ResultCodeEnum.USERNAME_NOT_EXIT);
        if(!user.getPassword().equals(DigestUtils.md5Hex(userDto.getPassword()))) throw new FxException(ResultCodeEnum.PASSWORD_ERROR);
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set(RedisConstant.TOKEN + ":" + token, JSON.toJSONString(user), 3, TimeUnit.HOURS);
        return token;
    }
}
