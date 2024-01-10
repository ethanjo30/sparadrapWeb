package com.sparadrapweb.sapradrapWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SapradrapWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SapradrapWebApplication.class, args);
	}

}
