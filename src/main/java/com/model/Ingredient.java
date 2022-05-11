package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Component
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private @Getter @Setter String name;
	private @Getter @Setter int quantityInMg;
	
}
