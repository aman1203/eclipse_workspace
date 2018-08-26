package com.example.feignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.example.feignClient","com.netflix.discovery"})
public class FeignClientConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientConsumerApplication.class, args);
	}
}
