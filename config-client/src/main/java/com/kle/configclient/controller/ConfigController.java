package com.kle.configclient.controller;

import com.kle.configclient.config.GitConfig;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置获取相关api
 * @author ypb
 */
@RestController
public class ConfigController {

    private final GitConfig gitConfig;

    public ConfigController(GitConfig gitConfig) {
        this.gitConfig = gitConfig;
    }

    @RequestMapping(value = "/getProjectName")
    private String getProjectName(){
        System.out.println("aa: " + gitConfig.getProjectName());
        return gitConfig.getProjectName();
    }

    @RequestMapping(value = "/getAuthor")
    public String getAuthor() {
        return gitConfig.getAuthor();
    }

    @RequestMapping(value = "/getVersion")
    public String getVersion(){
        return gitConfig.getVersion();
    }

}
