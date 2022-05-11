package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.model.User;

@Configuration
public class Config {
	@Bean
	public User getUser() {
		return new User(1,"pavan","kpa1sai",918216078,"kpa1@gamil.com");
	}
}
