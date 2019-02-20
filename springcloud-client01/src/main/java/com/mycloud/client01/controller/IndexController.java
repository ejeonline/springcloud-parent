package com.mycloud.client01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyingjie
 * @Title: IndexController
 * @Description: sss
 * @date 2019/2/19
 */
@RestController
public class IndexController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String hi(String name) {
        System.out.println("clientController");
        return "hi " + name + " , l am " + port + " port";
    }

}
