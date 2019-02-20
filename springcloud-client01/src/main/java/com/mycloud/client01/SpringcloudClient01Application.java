package com.mycloud.client01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudClient01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudClient01Application.class, args);
    }

}
