package com.hzau.science;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by cjx on 2017/4/30.
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.hzau.cs.dataparse", "com.hzau.cs.deployment", "com.hzau.cs.manageapplication" ,"com.hzau.science"})
@ImportResource(locations = { "classpath:applicationContext.xml" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
