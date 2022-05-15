package com.recipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.model.Recipe;
import com.recipe.service.RecipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/recipe")
@Api(value = "Recipe Controller", description = "CRUD for recipies")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@PostMapping(value="/addRecipe")
	@ApiOperation(value = "Get recipe details",httpMethod = "POST")
	public ResponseEntity<?> getUserDetails(@RequestBody Recipe dish){
		recipeService.save(dish);
		return new ResponseEntity<>("Dish added",HttpStatus.OK);
	}
	
	@GetMapping(value="/showRecipes")
	@ApiOperation(value = "Show all recipes",httpMethod = "GET")
	public ResponseEntity<?> showAllUsers(){
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes = recipeService.findAll();
		return new ResponseEntity<>(recipes,HttpStatus.OK);
	}
	
	@GetMapping(value="/showRecipeById")
	@ApiOperation(value = "Show single recipe",httpMethod = "GET")
	public ResponseEntity<?> showRecipeDetails(@RequestParam int id){
		Recipe dish = new Recipe();
		dish = recipeService.getById(id);
		return new ResponseEntity<>(dish,HttpStatus.OK);
	}
	

}
