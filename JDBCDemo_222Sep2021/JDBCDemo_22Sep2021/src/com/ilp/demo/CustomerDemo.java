package com.ilp.demo;

import java.util.List;

import com.ilp.bean.Customer;
import com.ilp.service.CustomerService;

public class CustomerDemo {
	
	public static void main(String[] args) {
		
		Customer customer1= new Customer(11,"Adam Henry", 34, "Chicago");
		
		System.out.println("Customer Registration status");
		
		System.out.println(CustomerService.registerCustomer(customer1));
		
		Customer customer2= new Customer(12,"Brian Henry", 32, "Denver");
		
		System.out.println("Customer Registration status");
		
		System.out.println(CustomerService.registerCustomer(customer2));
		
		Customer customer3= new Customer(13,"Craig Henry", 34, "Cincinnati");
		
		System.out.println("Customer Registration status");
		
		System.out.println(CustomerService.registerCustomer(customer3));
		
		Customer customer4= new Customer(14,"Don Henry", 35, "Chicago");
		
		System.out.println("Customer Registration status");
		
		System.out.println(CustomerService.registerCustomer(customer4));
		
//		String city="Denver";
		
//		System.out.println("Search customers in city "+ city);
//		
//		List<Customer> customers=CustomerService.searchCustomersByCity(city);
//		
//		if(customers.size()>0){
//			for(Customer customer: customers){
//				
//				System.out.println(customer.getCustomerId());
//				System.out.println(customer.getCustomerName());
//				System.out.println(customer.getAge());
//				System.out.println(customer.getCity());
//			}
//		}
//		else{
//			System.out.println("No records found");
//		}
		
	}

}
