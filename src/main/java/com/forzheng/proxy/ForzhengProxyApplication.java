package com.forzheng.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableFeignClients
@EnableZuulProxy
public class ForzhengProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForzhengProxyApplication.class, args);
		System.out.println("forzheng-proxy:启动完成");
	}
}
