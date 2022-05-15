package com.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.model.Recipe;
import com.recipe.repo.RecipeRepo;

@Service
public class RecipeService {
	@Autowired
	RecipeRepo recipeRepo;

	public Recipe save(Recipe dish) {
		return recipeRepo.save(dish);
		
	}

	public List<Recipe> findAll() {
		return recipeRepo.findAll();
	}

	public Recipe getById(int id) {
		return recipeRepo.getById(id);
	}
	
	

}
