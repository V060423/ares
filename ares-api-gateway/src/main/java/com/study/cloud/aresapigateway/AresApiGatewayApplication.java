package com.study.cloud.aresapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * API网关
 * 鉴权、降级、限流、异常处理、动态路由
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class AresApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AresApiGatewayApplication.class, args);
		System.out.println("启动网关服务！");
	}
}
