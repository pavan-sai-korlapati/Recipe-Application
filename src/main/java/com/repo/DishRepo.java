package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Dish;


@Repository
public interface DishRepo extends JpaRepository<Dish, Integer>{

}
