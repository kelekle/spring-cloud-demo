package com.kle.consumer.controller;

import com.kle.consumer.service.MyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务消费者，通过调用生产者完成服务
 * @author ypb
 */
@RestController
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(value = "/demo/get",method = RequestMethod.GET)
    public Object getInfo(){
        return myService.get();
    }

    @RequestMapping(value = "/demo/test",method = RequestMethod.GET)
    public String test(){
        return myService.testLoadBalance();
    }

}
