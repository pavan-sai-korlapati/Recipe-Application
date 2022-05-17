package com.recipe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.recipe.model.Recipe;
import com.recipe.repo.RecipeRepo;
import com.recipe.service.RecipeService;

@SpringBootTest
public class RecipeServiceTest {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeRepo recipeRepo;
	
	public static Recipe recipe1,recipe2,recipe3;
	@BeforeAll
	public static void setUp() {
		recipe1 = new Recipe();
		recipe2 = new Recipe();
		recipe3 = new Recipe();
		
		recipe1.setName("Maggi");
		recipe1.setInstructions("jhsdjhjdhsdjfjdffd");
		recipe1.setVeg(true);
		
		recipe2.setName("Dosa");
		recipe2.setInstructions("hdhdhdhfhjfjhd");
		recipe2.setVeg(true);
	}
	
	@Test
	@DisplayName("Test case of create Recipe")
	void createRecipeTest() {
		
		recipeRepo.save(recipe1);
		assertNotNull(recipe1);

	}
	
	@Test
	@DisplayName("Positive Test case of create Recipe")
	void createRecipeTest1() {
		
	when(recipeRepo.save(recipe1)).thenReturn(recipe1);
	assertEquals(recipe1, recipeService.save(recipe1,1));
		
	}
	

}
