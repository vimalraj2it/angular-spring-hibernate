package com.cracker.service;

import java.util.ArrayList;



import com.cracker.domain.OrderDetails;
import com.cracker.domain.UserCrk;



public interface OrderDetailsService {

	public void save(ArrayList<OrderDetails> list,UserCrk userCrk);
}
