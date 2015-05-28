package com.cracker.service;

import java.util.ArrayList;

import com.cracker.domain.Products;

public interface ProductsService {
	
	public ArrayList<Products> list();
	public void save(Products product); 
}
