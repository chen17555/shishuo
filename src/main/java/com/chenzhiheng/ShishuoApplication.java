package com.chenzhiheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
@MapperScan("xin.sysout.mapper")
public class ShishuoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShishuoApplication.class, args);
	}

}
