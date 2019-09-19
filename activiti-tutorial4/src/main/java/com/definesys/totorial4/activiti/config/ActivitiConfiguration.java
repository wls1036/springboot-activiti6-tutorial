package com.definesys.totorial4.activiti.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/9/20 1:23 AM
 * @history: 1.2019/9/20 created by jianfeng.zheng
 */
@Configuration
public class ActivitiConfiguration {
    @Bean
    @Primary
    public DataSource database() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEncoding=utf8")
                .username("activiti")
                .password("definesys")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }
}
