package com.dh.project02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//两者方式，第一种每一个类上加mapper,或者启动程序上加MapperScan
@MapperScan
public class Project02Application {

    public static void main(String[] args) {
        SpringApplication.run(Project02Application.class, args);
    }

}
