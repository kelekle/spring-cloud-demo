package com.kle.consumer.service;

import com.kle.consumer.service.fallback.MyServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * openfegin服务接口，调用producer-service服务
 * @author ypb
 */
@FeignClient(value = "producer-service", fallback = MyServiceFallbackImpl.class)
public interface MyService {

    /**
     * @return something get from database
     */
    @RequestMapping(value = "/get")
    Object get();

    /**
     * @return something with port
     */
    @RequestMapping(value = "/test")
    String testLoadBalance();

}
