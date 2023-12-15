package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringbootRegisterationLogin3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRegisterationLogin3Application.class, args);
	}

}
