package com.kle.configclient.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author ypb
 */
@RefreshScope
@Component
@Data
public class GitConfig {

    @Value("${author}")
    private String author;

    @Value("${projectName}")
    private String projectName;

    @Value("${version}")
    private String version;

}
