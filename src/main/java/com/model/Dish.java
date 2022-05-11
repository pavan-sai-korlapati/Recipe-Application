package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Entity
@Component
public class Dish {
	private @Getter @Setter String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private @Getter @Setter boolean isVeg;
	@OneToMany
	private @Getter @Setter List<Ingredient> ingredients;
	private @Getter @Setter String instructions;
	@CreatedBy
	@ManyToOne
	private @Getter @Setter User user;
	@LastModifiedDate
	private @Getter @Setter Date modifiedDate;
	@CreatedDate
	private @Getter @Setter Date createdDate;
	
	
	
}
