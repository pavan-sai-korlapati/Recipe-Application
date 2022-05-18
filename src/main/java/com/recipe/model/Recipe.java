package com.recipe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
 public class Recipe {
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int recipeId;
	private boolean isVeg;
	@OneToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "recipeId")
	private List<Ingredient> ingredients;
	private String instructions;
	@LastModifiedDate
	private Date modifiedDate;
	@CreatedDate
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date createdDate;
	
	
	
}
