package com.recipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.exception.RecipeNotFoundException;
import com.recipe.exception.UserNotFoundException;
import com.recipe.model.Recipe;
import com.recipe.service.RecipeService;
import com.recipe.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/recipe")
@Api(value = "Recipe Controller", description = "CRUD for recipies")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	@Autowired
	UserService userService;
	
	@PostMapping(value="/addRecipe")
	@ApiOperation(value = "Get recipe details",httpMethod = "POST")
	public ResponseEntity<?> getRecipeDetails(@RequestBody Recipe dish,@RequestParam int userId)throws UserNotFoundException{
		if(!userService.existsById(userId)) throw new UserNotFoundException("User doesnot exist");
		recipeService.save(dish,userId);
		return new ResponseEntity<>("Dish added",HttpStatus.OK);
	}
	
	@GetMapping(value="/showRecipes")
	@ApiOperation(value = "Show all recipes",httpMethod = "GET")
	public ResponseEntity<?> showAllRecipes(){
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes = recipeService.findAll();
		return new ResponseEntity<>(recipes,HttpStatus.OK);
	}
	
	@GetMapping(value="/showRecipeById")
	@ApiOperation(value = "Show single recipe",httpMethod = "GET")
	public ResponseEntity<?> showRecipeDetails(@RequestParam int id)throws RecipeNotFoundException{
		if(recipeService.existsById(id))
		return new ResponseEntity<>(recipeService.getById(id),HttpStatus.OK);
		throw new RecipeNotFoundException("Recipe not found");
	}
	
	@DeleteMapping(value="/deleteRecipeById")
	@ApiOperation(value = "Delete single recipe",httpMethod = "DELETE")
	public ResponseEntity<?> deleteRecipeById(@RequestParam int id) throws RecipeNotFoundException{
		if(recipeService.existsById(id)) {
			recipeService.deleteById(id);
			return new ResponseEntity<String>("Succesfully deleted.",HttpStatus.OK);
		}
		throw new RecipeNotFoundException("No recipe found for given ID");
	}
	
	@GetMapping(value = "/showVegRecipes")
	@ApiOperation(value = "Show veg recipes",httpMethod = "GET")
	public ResponseEntity<?> showVegRecipes(){
		List<Recipe> recipes = recipeService.getVegRecipes(true);
		return new ResponseEntity<>(recipes,HttpStatus.OK);
	}
	

}
