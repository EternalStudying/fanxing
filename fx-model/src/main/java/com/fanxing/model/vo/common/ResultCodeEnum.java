package com.fanxing.model.vo.common;

import lombok.Getter;

@Getter // 提供获取属性值的getter方法
public enum ResultCodeEnum {

    SUCCESS(200 , "操作成功") ,
    LOGIN_ERROR(201 , "用户名或者密码错误"),
    USERNAME_NOT_EXIT(202, "亲~你不要玩我哦!"),
    PASSWORD_ERROR(203, "密码错误啦哥哥"),
    LOGIN_AUTH(204, "请先登录哦"),
    SYSTEM_ERROR(9999 , "您的网络有问题请稍后重试");

    private Integer code ;      // 业务状态码
    private String message ;    // 响应消息

    private ResultCodeEnum(Integer code , String message) {
        this.code = code ;
        this.message = message ;
    }

}
