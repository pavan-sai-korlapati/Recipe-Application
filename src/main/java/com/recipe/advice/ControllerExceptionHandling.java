package com.recipe.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.recipe.exception.RecipeNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandling {
	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<?> recipeNotFoundExceptionMethod (RecipeNotFoundException recipeNotFound){
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "Creation Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", recipeNotFound.getMessage());

		return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public void exceptionHandler (Exception exception){
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "Creation Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", exception.getMessage());
	}
}
