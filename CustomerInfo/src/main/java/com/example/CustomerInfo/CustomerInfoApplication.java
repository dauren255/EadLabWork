package com.example.CustomerInfo;

import com.example.CustomerInfo.models.Role;
import com.example.CustomerInfo.models.User;
import com.example.CustomerInfo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerInfoApplication.class, args);
	}

}
