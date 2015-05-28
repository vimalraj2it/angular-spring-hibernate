package com.cracker.dbservice;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.cracker.domain.Supplier;
import com.cracker.util.HibernateUtil;

public class SupplierService extends HibernateUtil {

	Session session;

	public SupplierService() {
		session = getSession();
	}

	public void saveSupplier(Supplier supplier) {
		try {
			session.beginTransaction();
			session.saveOrUpdate(supplier);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdown();
		}
	}

	public void deleteSupplier(Supplier supplier) {
		try {
			session.beginTransaction();
			session.delete(supplier);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdown();
		}
	}

	public ArrayList<Supplier> getSupplierList() {
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Supplier.class);
			ArrayList<Supplier> list = (ArrayList<Supplier>) criteria.list();
			session.getTransaction().commit();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			shutdown();
		}
		return null;
	}
}
