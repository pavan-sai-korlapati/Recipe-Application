package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Component
public class User {
	public User() {
	}
	public User(int id, String name, String password, long mobile, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter int id;
	private @Getter @Setter String name;
	private @Getter @Setter String password;
	private @Getter @Setter long mobile;
	private @Getter @Setter String email;
	
	

}
