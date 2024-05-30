package com.fanxing.user.controller;

import com.fanxing.model.dto.user.UserDto;
import com.fanxing.model.vo.common.Result;
import com.fanxing.model.vo.common.ResultCodeEnum;
import com.fanxing.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/user/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody UserDto userDto){
        userService.register(userDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDto userDto){
        String token = userService.login(userDto);
        return Result.build(token, ResultCodeEnum.SUCCESS);
    }
}
