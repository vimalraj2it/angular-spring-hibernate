package com.cracker.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cracker.dao.SupplierDao;
import com.cracker.domain.Products;
import com.cracker.domain.Supplier;

public class SupplierDaoImpl implements SupplierDao{
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@Override
	public ArrayList<Supplier> list() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		
		Criteria criteria =	session.createCriteria(Supplier.class);
	
		ArrayList<Supplier> supplierList = (ArrayList<Supplier>) criteria.list();
		session.close();
		return supplierList;
	}
	@Override
	public void save(Supplier supplier) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(supplier.getSupp_id());
		session.save(supplier);
		System.out.println(supplier.getSupp_id());
		for (Products product : supplier.getProductSet()) {
			product.setSupplier_id(supplier.getSupp_id());
			session.save(product);
		}
		tx.commit();
		session.close();
		
	}

}
