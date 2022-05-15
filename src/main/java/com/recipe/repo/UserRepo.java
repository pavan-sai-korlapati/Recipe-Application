package com.recipe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
