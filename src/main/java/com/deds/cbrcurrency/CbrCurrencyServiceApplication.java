package com.deds.cbrcurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CbrCurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbrCurrencyServiceApplication.class, args);
	}

}
