package com.mycloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liyingjie
 * @Title: HelloService
 * @Description: sss
 * @date 2019/2/19
 */
@Service
public class HelloService {
    /**
     * 将IOC容器中的负载均衡RestTemplate工具注入进来
     */
    @Autowired//@Reference是dubbo的注解 @Reference注入的是分布式中的远程服务对象，@Resource和@Autowired注入的是本地spring容器中的对象。
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "obtainFailure")
    public String obtainOtherServiceData(String name) {
        System.out.println("ribbonservice");
        //尝试调用其它微服务接口，访问的是SERVICE-CLIENT这个服务器的/hi 接口
        return restTemplate.getForObject("http://SERVICE-CLIENT/hi?name=" + name, String.class);
    }

    public String obtainFailure(String name){
        return "sorry" + name + ", server internal error";
    }
}
