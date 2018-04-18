package com.study.cloud.ares.register.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AresRegisterCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AresRegisterCenterApplication.class, args);
		System.out.println("服务注册中心启动成功");
	}
}
