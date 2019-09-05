package com.definesys.totorial.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/9/5 11:02 AM
 * @history: 1.2019/9/5 created by jianfeng.zheng
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivititiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivititiApplication.class);
    }
}
