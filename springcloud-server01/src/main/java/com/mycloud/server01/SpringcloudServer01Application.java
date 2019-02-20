package com.mycloud.server01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServer01Application.class, args);
    }

}
