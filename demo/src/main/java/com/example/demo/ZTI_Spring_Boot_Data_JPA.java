package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ZTI_Spring_Boot_Data_JPA {

	public static void main(String[] args) {
		SpringApplication.run(ZTI_Spring_Boot_Data_JPA.class, args);
	}

}
