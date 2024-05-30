package com.fanxing.user.service;

import com.fanxing.model.dto.user.UserDto;

public interface UserService {
    void register(UserDto userDto);

    String login(UserDto userDto);
}
