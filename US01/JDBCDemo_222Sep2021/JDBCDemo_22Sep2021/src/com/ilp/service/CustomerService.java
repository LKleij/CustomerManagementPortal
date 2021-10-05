package com.ilp.service;

import java.util.List;

import com.ilp.bean.Customer;
import com.ilp.dao.CustomerDao;

public class CustomerService {
	
	public static boolean registerCustomer(Customer customer){
		CustomerDao dao = new CustomerDao();
		
		return dao.registerCustomer(customer);
		
	}
	
	public static List<Customer> getCustomerslist( ){
		CustomerDao dao = new CustomerDao();
		return dao.getCustomerslist();
	}

}
