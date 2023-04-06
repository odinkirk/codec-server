package com.odinkirk.codecserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CodecServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodecServerApplication.class, args);
	}

}
