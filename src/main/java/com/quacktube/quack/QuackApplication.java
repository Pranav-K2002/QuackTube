package com.quacktube.quack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Locale;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication
public class QuackApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuackApplication.class, args);
	}

}
