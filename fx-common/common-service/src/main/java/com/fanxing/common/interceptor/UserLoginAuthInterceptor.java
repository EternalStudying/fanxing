package com.fanxing.common.interceptor;

import com.alibaba.fastjson2.JSON;
import com.fanxing.model.constant.RedisConstant;
import com.fanxing.model.entity.user.User;
import com.fanxing.utils.AuthContextUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class UserLoginAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String userJson = redisTemplate.opsForValue().get(RedisConstant.TOKEN + ":" + token);

        //放到threadLocal里面
        AuthContextUtils.setUser(JSON.parseObject(userJson, User.class));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AuthContextUtils.removeUser();
    }
}
