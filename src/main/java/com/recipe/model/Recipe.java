package com.recipe.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
@NoArgsConstructor
@RequiredArgsConstructor
public class Recipe {
	@NonNull
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int recipeId;
	private boolean isVeg;
	@OneToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "recipeId")
	private List<Ingredient> ingredients;
	private String instructions;
	@CreatedBy
	@ManyToOne
	private User user;
	@LastModifiedDate
	private Date modifiedDate;
	@CreatedDate
	private Date createdDate;
	
	
	
}
