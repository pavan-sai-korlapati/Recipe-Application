package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int quantityInMg;
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantityInMg() {
		return quantityInMg;
	}
	public void setQuantityInMg(int quantityInMg) {
		this.quantityInMg = quantityInMg;
	}
	
}
