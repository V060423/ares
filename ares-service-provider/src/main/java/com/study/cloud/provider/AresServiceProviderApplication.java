package com.study.cloud.provider;

import com.study.cloud.domain.User;
import com.study.cloud.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

/**
 * @SpringBootApplication 默认扫描的路径，是该工程application启动类所在包以及所有子包下的所有文件。
 */
@EnableEurekaClient
@EnableFeignClients({"com.study.cloud.service"})
@ComponentScan(value ={
		"com.study.cloud.provider.user",
		"com.study.cloud.service.fallback"})
@EnableJpaRepositories(basePackages = "com.study.cloud.repository")
@EntityScan("com.study.cloud.domain")
@SpringBootApplication
public class AresServiceProviderApplication  {
	public static void main(String[] args) {
		 SpringApplication.run(AresServiceProviderApplication.class, args);
		System.out.println("服务提供者启动成功！");
	}


}
