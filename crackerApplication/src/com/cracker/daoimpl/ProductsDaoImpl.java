package com.cracker.daoimpl;

import java.util.ArrayList;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cracker.dao.ProductsDao;
import com.cracker.domain.Products;


public class ProductsDaoImpl implements ProductsDao{
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@Override
	public ArrayList<Products> list() {
		Session session = this.sessionFactory.openSession();
		ArrayList<Products> productList = (ArrayList<Products>) session.createQuery("from Person").list();
		session.close();
		return productList;
	}
	@Override
	public void save(Products product) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(product);
		tx.commit();
		session.close();
		
	}

}
