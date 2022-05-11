package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public void save(User user) {
		userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User getById(int id) {
		return userRepo.getById(id);
	}
}
