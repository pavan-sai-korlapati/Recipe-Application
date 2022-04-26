package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repo.DishRepo;

@Service
public class RecipeService {
	@Autowired
	DishRepo dishRepo;

}
