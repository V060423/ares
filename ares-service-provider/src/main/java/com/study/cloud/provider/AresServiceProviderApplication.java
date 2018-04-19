package com.study.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @SpringBootApplication 默认扫描的路径，是该工程application启动类所在包以及所有子包下的所有文件。
 */
@EnableEurekaClient
@EnableFeignClients({"com.study.cloud.service"})
@SpringBootApplication(scanBasePackages ={"com.study.cloud.provider.user"})
@ComponentScan(basePackages = {"com.study.cloud.repository"})
public class AresServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AresServiceProviderApplication.class, args);
		System.out.println("服务提供者启动成功！");
	}
}
