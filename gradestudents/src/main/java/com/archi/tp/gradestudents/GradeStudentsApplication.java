package com.archi.tp.gradestudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GradeStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeStudentsApplication.class, args);
	}

}
