package com.cracker.util;

import java.util.ArrayList;

import com.cracker.domain.Supplier;
import com.cracker.domain.UserCrk;

public class ResponseJson {
	private UserCrk user;
	private ArrayList<Supplier> suppliers;
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	public UserCrk getUser() {
		return user;
	}
	public void setUser(UserCrk user) {
		this.user = user;
	}
}
