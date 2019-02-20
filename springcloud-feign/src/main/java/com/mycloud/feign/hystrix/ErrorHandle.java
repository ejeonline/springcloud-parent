package com.mycloud.feign.hystrix;

import com.mycloud.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liyingjie
 * @Title: ErrorHandle
 * @Description: hystrix fallback
 * @date 2019/2/20
 */
@Component
public class ErrorHandle implements HelloService {
    @Value("${server.port}")
    private String port;
    @Override
    public String obtainOtherServerJsonData(String name) {
        return "sorry " + name + " , " + port + ", server internal error";
    }
}
