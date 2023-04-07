package com.odinkirk.codecserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.odinkirk.codecserver")
public class CodecServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodecServerApplication.class, args);
    }

}
