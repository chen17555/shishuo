package com.czh.shishuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class ShishuoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShishuoApplication.class, args);
	}

}
