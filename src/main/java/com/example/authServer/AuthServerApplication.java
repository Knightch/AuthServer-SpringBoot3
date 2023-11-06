package com.example.authServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager (){
		var one = User
				.withDefaultPasswordEncoder()
				.roles("admin")
				.username("aman")
				.password("pw")
				.build();
		var two = User
				.withDefaultPasswordEncoder()
				.roles("user")
				.username("raju")
				.password("pw")
				.build();
		return new InMemoryUserDetailsManager(one, two);
	}

}
