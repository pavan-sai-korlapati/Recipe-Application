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

import com.recipe.model.User;
import com.recipe.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/user")
@Api(value = "User Controller", description = "Values for user controller")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/addUser")
	@ApiOperation(value = "Get user details",httpMethod = "POST")
	public ResponseEntity<?> getUserDetails(@RequestBody User user){
		userService.save(user);
		return new ResponseEntity<>("User added",HttpStatus.OK);
	}
	
	@GetMapping(value="/showusers")
	@ApiOperation(value = "Show all users",httpMethod = "GET")
	public ResponseEntity<?> showAllUsers(){
		List<User> users = new ArrayList<User>();
		users = userService.findAll();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping(value="/showUserById")
	@ApiOperation(value = "Show single user",httpMethod = "GET")
	public ResponseEntity<?> showUserDetails(@RequestParam int id){
		User user = new User();
		user = userService.getById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}

