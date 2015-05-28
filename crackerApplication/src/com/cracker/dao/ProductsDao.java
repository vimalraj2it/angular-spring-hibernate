package com.cracker.dao;

import java.util.ArrayList;

import com.cracker.domain.Products;

public interface ProductsDao {
	
	public ArrayList<Products> list();
	public void save(Products product); 
}
