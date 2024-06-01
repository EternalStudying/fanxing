package com.fanxing.gateway.filter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fanxing.model.constant.RedisConstant;
import com.fanxing.model.entity.user.User;
import com.fanxing.model.vo.common.Result;
import com.fanxing.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1. 获取请求路径
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();

        //2. 判断路径/**/auth/**，登录校验
        if (antPathMatcher.match("/**/auth/**", path)){
            User user = this.getUser(request);
            if (user == null){
                ServerHttpResponse response = exchange.getResponse();
                return out(response, ResultCodeEnum.LOGIN_AUTH);
            }
        }

        //放行
        return chain.filter(exchange);
    }

    private User getUser(ServerHttpRequest request) {
        //1. 获取token
        String token = "";
        List<String> tokenList = request.getHeaders().get("token");
        if (tokenList != null){
            token = tokenList.get(0);
        }

        //2. 获取数据
        if (StringUtils.hasText(token)){
            String userJson = redisTemplate.opsForValue().get(RedisConstant.TOKEN + ":" + token);
            if (StringUtils.hasText(userJson)){
                return JSON.parseObject(userJson, User.class);
            }else {
                return null;
            }
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private Mono<Void> out(ServerHttpResponse response, ResultCodeEnum resultCodeEnum) {
        Result result = Result.build(null, resultCodeEnum);
        byte[] bits = JSONObject.toJSONString(result).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
