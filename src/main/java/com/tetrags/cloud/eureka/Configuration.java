package com.tetrags.cloud.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
    @Value("${eureka.web.path}")
    private String eurekaWebPath;

    String getEurekaWebPath(){
        return eurekaWebPath;
    }


    @Value("${server.tomcat.basedir}")
    private String tomcatBaseDir;

    String getTomcatBaseDir(){
        return tomcatBaseDir;
    }
}
