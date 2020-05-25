package com.kle.consumer.service;

import com.kle.consumer.service.fallback.MyServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * openfegin服务接口，调用producer-service服务
 * @author ypb
 */
@FeignClient(value = "producer-service", fallback = MyServiceFallback.class)
public interface MyService {

    /**
     * @return something get from database
     */
    @RequestMapping(value = "/get")
    Object get();

    /**
     * @return
     */
    @RequestMapping(value = "/test")
    String testLoadBalance();

}
