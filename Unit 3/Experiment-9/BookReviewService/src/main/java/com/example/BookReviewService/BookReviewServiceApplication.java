package com.example.BookReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookReviewServiceApplication.class, args);
	}

}
