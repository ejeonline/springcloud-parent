package com.mycloud.ribbon.controller;

import com.mycloud.ribbon.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liyingjie
 * @Title: HelloController
 * @Description: test
 * @date 2019/2/19
 */
@RestController
public class HelloController {

    @Resource
    HelloService helloService;

    @RequestMapping("hello")
    public String hello(String name){
        System.out.println("ribboncontroller");
        //调用Service接口，并返回JSON数据
        return helloService.obtainOtherServiceData(name);
    }

}
