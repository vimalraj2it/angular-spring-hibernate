package com.cracker.serviceimpl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cracker.dao.SupplierDao;
import com.cracker.domain.Supplier;
import com.cracker.service.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService{

	
	
	private SupplierDao supplierDao;
	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	@Override
	public ArrayList<Supplier> list() {
		// TODO Auto-generated method stub
		return supplierDao.list();
	}

	@Override
	public void save(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}

}
