package com.cracker.dao;

import java.util.ArrayList;

import com.cracker.domain.Supplier;

public interface SupplierDao {

	
	public ArrayList<Supplier> list();
	
	
	public void save(Supplier supplier);
	
}
