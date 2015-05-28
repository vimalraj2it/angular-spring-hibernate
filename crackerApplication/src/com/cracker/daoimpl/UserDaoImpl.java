package com.cracker.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.cracker.dao.UserDao;
import com.cracker.domain.UserCrk;

public class UserDaoImpl implements UserDao{

	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(UserCrk user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
		
	}

	@Override
	public UserCrk get(String userId) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserCrk.class);
		criteria.add(Restrictions.eq("user_name", userId));
		return (UserCrk) criteria.uniqueResult();
	}

	
	
}
