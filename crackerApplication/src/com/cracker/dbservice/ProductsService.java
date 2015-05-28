package com.cracker.dbservice;

import org.hibernate.Session;

import com.cracker.domain.Products;
import com.cracker.util.HibernateUtil;

public class ProductsService extends HibernateUtil{
	
	
	Session session;
	
	
	public ProductsService(){
		session = getSession();
	}

	
	public void saveProducts(Products products){
		try{
			session.beginTransaction();
			session.saveOrUpdate(products);
			session.getTransaction().commit(); 
			 
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			shutdown();
		}
	}
	
	
	public void deleteProducts(Products products){
		try{
			session.beginTransaction();
			session.delete(products);
			session.getTransaction().commit(); 
			 
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			shutdown();
		}
	}
}
