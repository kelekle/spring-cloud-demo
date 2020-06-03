package com.kle.producer.controller;

import com.kle.producer.dao.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务生产者1，提供服务
 * @author ypb
 */
@RestController
public class MyController {

    private final StudentMapper studentMapper;

    @Value("${server.port}")
    private String port;

    public MyController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @RequestMapping(value = "/get")
    public Object getAllStudent(){
        return studentMapper.selectAll();
    }

    @RequestMapping(value = "/test")
    public String testLoadBalance(){
        return "I'm port:" + port;
    }

}
