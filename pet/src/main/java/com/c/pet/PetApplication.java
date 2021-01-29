package com.c.pet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.c.pet.dao")
@EnableTransactionManagement
public class PetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetApplication.class, args);
    }

}
