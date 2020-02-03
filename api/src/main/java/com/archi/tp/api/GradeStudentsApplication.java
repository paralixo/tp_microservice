package com.archi.tp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class GradeStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeStudentsApplication.class, args);
	}
}
