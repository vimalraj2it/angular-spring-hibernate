package com.cracker.service;

import java.util.ArrayList;

import com.cracker.domain.Supplier;

public interface SupplierService{

	
	public ArrayList<Supplier> list();
	
	
	public void save(Supplier supplier);
	
}
