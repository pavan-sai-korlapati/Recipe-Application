package com.recipe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.model.Recipe;


@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer>{

	List<Recipe> findByIsVeg(boolean isVeg);
	
	
	

}
