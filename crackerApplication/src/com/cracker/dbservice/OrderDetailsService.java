package com.cracker.dbservice;

import org.hibernate.Session;

import com.cracker.domain.OrderDetails;
import com.cracker.util.HibernateUtil;

public class OrderDetailsService extends HibernateUtil{
	
	
	Session session;
	
	
	public OrderDetailsService(){
		session = getSession();
	}

	
	public void saveOrderDetails(OrderDetails orderDetails){
		try{
			session.beginTransaction();
			session.saveOrUpdate(orderDetails);
			session.getTransaction().commit(); 
			 
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			shutdown();
		}
	}
	
	
	public void deleteOrderDetails(OrderDetails orderDetails){
		try{
			session.beginTransaction();
			session.delete(orderDetails);
			session.getTransaction().commit(); 
			 
			  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			shutdown();
		}
	}
}
