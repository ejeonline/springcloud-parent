package com.mycloud.feign.controller;

import com.mycloud.feign.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liyingjie
 * @Title: HelloController
 * @Description: sss
 * @date 2019/2/20
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        System.out.println("feignController");
        return helloService.obtainOtherServerJsonData(name);
    }

}
