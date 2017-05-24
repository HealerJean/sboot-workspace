package com.wisely.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //1 使用这个注解开启对服务发现的支持
public class DiscoveryApplication {

	  public static void main(String[] args) {
	        SpringApplication.run(DiscoveryApplication.class, args);
	    }

}
