package com.fanxing.galaxy;

import com.fanxing.common.annotation.EnableUserLoginAuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fanxing"})
@EnableUserLoginAuthInterceptor
@EnableFeignClients(basePackages = {"com.fanxing"})
public class GalaxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(GalaxyApplication.class, args);
    }
}
