package com.cracker.serviceimpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cracker.dao.OrderDetailsDao;
import com.cracker.domain.OrderDetails;
import com.cracker.domain.UserCrk;
import com.cracker.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	
	private OrderDetailsDao orderDetailsDao; 
	
	
	public void setOrderDetailsDao(OrderDetailsDao orderDetailsDao) {
		this.orderDetailsDao = orderDetailsDao;
	}


	@Override
	public void save(ArrayList<OrderDetails> list,UserCrk userCrk) {
		// TODO Auto-generated method stub
		orderDetailsDao.save(list, userCrk);
	}

}
