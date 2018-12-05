package com.brs.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


/**
 * @author tiny lin
 * @date  2018/11/30
*/

@SpringBootApplication
@MapperScan("com.brs.oa.*.mapper")
@EnableConfigurationProperties
public class OaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OaApplication.class, args);
    }
}
