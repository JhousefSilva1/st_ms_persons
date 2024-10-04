package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SmartTollsPersonsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartTollsPersonsServiceApplication.class, args);
	}

}
