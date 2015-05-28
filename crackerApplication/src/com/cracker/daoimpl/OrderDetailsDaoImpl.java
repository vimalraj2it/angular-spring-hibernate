package com.cracker.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cracker.dao.OrderDetailsDao;
import com.cracker.domain.OrderDetails;
import com.cracker.domain.UserCrk;

public class OrderDetailsDaoImpl implements OrderDetailsDao{
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@Override
	public void save(ArrayList<OrderDetails> list,UserCrk userCrk) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		for (OrderDetails orderDetails : list) {
			orderDetails.setUser_id(userCrk.getUser_id());
			session.save(orderDetails);
		}
		
		tx.commit();
		session.close();
		
	}

}
