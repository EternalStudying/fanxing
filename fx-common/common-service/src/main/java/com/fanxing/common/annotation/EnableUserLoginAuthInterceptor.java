package com.fanxing.common.annotation;


import com.fanxing.common.config.UserWebMvcConfiguration;
import com.fanxing.common.interceptor.UserLoginAuthInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Import(value = {UserLoginAuthInterceptor.class, UserWebMvcConfiguration.class})
public @interface EnableUserLoginAuthInterceptor {
}
