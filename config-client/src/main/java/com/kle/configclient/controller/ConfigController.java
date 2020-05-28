package com.kle.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置获取相关api
 * @author ypb
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${author}")
    private String author;

    @Value("${projectName}")
    private String projectName;

    @Value("${version}")
    private String version;

    @RequestMapping(value = "/getProjectName")
    private String getProjectName(){
        System.out.println("aa: " + projectName);
        return projectName;
    }

    @RequestMapping(value = "/getAuthor")
    public String getAuthor() {
        return author;
    }

    @RequestMapping(value = "/getVersion")
    public String getVersion(){
        return version;
    }

}
