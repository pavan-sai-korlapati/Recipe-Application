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
		return recipeRepo.findById(id).get();
	}
	
	public boolean existsById(int recipeId) {
		return recipeRepo.existsById(recipeId);
	}
	
	public void deleteById(int id) {
			recipeRepo.deleteById(id);
	}
	public List<Recipe> getVegRecipes(boolean isVeg){
		return recipeRepo.findByIsVeg(isVeg);
	}
	

}
