package com.recipe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.model.Recipe;


@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer>{

}
