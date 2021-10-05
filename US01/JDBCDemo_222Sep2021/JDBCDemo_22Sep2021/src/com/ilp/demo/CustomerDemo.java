package com.ilp.demo;

import java.util.List;

import com.ilp.bean.Customer;
import com.ilp.service.CustomerService;

public class CustomerDemo {
	
	public static void main(String[] args) {
		Customer c1 = new Customer("1","Adam Henry", "34", "Chicago","haha@email.com");
		Customer c2 = new Customer("2","Adam ", "35", "Ch","1haha@email.com");
		Customer c3 = new Customer("3","Henry", "33", "ago","2haha@email.com");
		Customer c4 = new Customer("4","Adam ", "30", "Chic","3haha@email.com");
		
		
		System.out.println("Customer registration status");
		System.out.println(CustomerService.registerCustomer(c1));
		System.out.println(CustomerService.registerCustomer(c2));
		System.out.println(CustomerService.registerCustomer(c3));
		System.out.println(CustomerService.registerCustomer(c4));
	
		List<Customer> customers = CustomerService.getCustomerslist();
		for (Customer cust : customers){
			System.out.println(cust.getName());
		}

		
//		String address = "ago";
//		System.out.println("Search customers in Address" + address);
//		List<Customer> customers = CustomerService.searchCustomerByAddress(address);
		
//		if(customers.size()>0){
//			for (Customer customer: customers){
//				System.out.println(customer.getCustomerId());
//				System.out.println(customer.getName());
//				System.out.println(customer.getContactNumber());
//				System.out.println(customer.getAddress());
//				System.out.println(customer.getemail());
//			}
//		}
		
//		else{
//			System.out.println("No found");
//		}
		
		
		
	}

}
