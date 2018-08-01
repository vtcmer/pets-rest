package com.sinz.pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PetsApplication {
	// -- nueva rama del token modificada
	public static void main(String[] args) {
		SpringApplication.run(PetsApplication.class, args);
	}

}
