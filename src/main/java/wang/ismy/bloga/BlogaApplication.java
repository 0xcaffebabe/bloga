package wang.ismy.bloga;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import wang.ismy.bloga.config.Config;

import java.io.IOException;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling


public class BlogaApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogaApplication.class, args);
    }
}
