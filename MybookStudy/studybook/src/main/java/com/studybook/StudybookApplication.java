package com.studybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/*
使用上面三个的注解和下面这个@SpringBootApplication的效果是一样的
@Configuration
@EnableAutoConfiguration
@ComponentScan

*/
@SpringBootApplication
public class StudybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudybookApplication.class, args);
	}
}
