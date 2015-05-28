package com.cracker.dao;

import java.util.ArrayList;



import com.cracker.domain.OrderDetails;
import com.cracker.domain.UserCrk;



public interface OrderDetailsDao {

	public void save(ArrayList<OrderDetails> list,UserCrk userCrk);
}
