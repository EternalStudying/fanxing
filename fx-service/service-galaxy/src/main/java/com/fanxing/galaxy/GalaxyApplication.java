package com.fanxing.galaxy;

import com.fanxing.common.annotation.EnableUserLoginAuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fanxing"})
@EnableUserLoginAuthInterceptor
public class GalaxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(GalaxyApplication.class, args);
    }
}
