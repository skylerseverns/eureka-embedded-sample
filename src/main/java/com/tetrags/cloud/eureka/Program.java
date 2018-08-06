package com.tetrags.cloud.eureka;

import org.apache.catalina.Context;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class Program {

    @Autowired
    private Configuration configuration;

    public static void main(String[] args){
        SpringApplication.run(Program.class, args);
    }

    @Bean
    public TomcatServletWebServerFactory containerFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
                try {
                    createWebAppsDirectory();
                    Context context = tomcat.addWebapp("/eureka", configuration.getEurekaWebPath());
                    WebappLoader loader = new WebappLoader(Thread.currentThread().getContextClassLoader());
                    context.setLoader(loader);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

                return super.getTomcatWebServer(tomcat);
            }
        };
    }

    private void createWebAppsDirectory(){
        File file = new File(configuration.getTomcatBaseDir() + "webapps");
        if (!file.exists()) file.mkdir();
    }
}
