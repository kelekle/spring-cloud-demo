package com.kle.consumer.service.fallback;

import com.kle.consumer.service.MyService;
import org.springframework.stereotype.Component;

/**
 * 服务不可用时的hystrix返回
 * @author ypb
 */
@Component
public class MyServiceFallback implements MyService {

    @Override
    public Object get() {
        return "Sorry, the service is unreachable now";
    }

    @Override
    public String testLoadBalance() {
        return "Sorry, the LoadBalance test service is unreachable now";
    }
}
