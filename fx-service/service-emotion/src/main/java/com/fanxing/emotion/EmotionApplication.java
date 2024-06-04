package com.fanxing.emotion;

import com.fanxing.common.annotation.EnableUserLoginAuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fanxing"})
@EnableUserLoginAuthInterceptor
public class EmotionApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmotionApplication.class, args);
    }
}
