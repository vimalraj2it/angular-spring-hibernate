package com.cracker.serviceimpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cracker.dao.ProductsDao;
import com.cracker.domain.Products;
import com.cracker.service.ProductsService;
@Service
public class ProductsServiceImpl implements ProductsService{

	
	private ProductsDao productsDao;
	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}

	@Override
	public ArrayList<Products> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Products product) {
		// TODO Auto-generated method stub
		
	}

}
