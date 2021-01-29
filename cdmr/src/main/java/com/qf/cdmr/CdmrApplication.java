package com.qf.cdmr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * springboot项目的启动类
 */
@SpringBootApplication
@MapperScan("com.qf.cdmr.dao")
@EnableTransactionManagement

public class CdmrApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdmrApplication.class, args);
    }

}
