package com.definesys.totorial4.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/9/19 6:16 PM
 * @history: 1.2019/9/19 created by jianfeng.zheng
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = {"com.definesys.*"})
public class ActivititiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivititiApplication.class);
    }
}
