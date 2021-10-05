package com.ilp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ilp.bean.Customer;

public class CustomerDao {
	public static final String JDBC_URL = "jdbc:derby:C:\\Users\\2072301\\MyDB;create=true";
	public static final String USERNAME ="test";
	public static final String PASSWORD ="test";
	
	
	public Connection con = null;
	public ResultSet rs = null;
	
	public boolean registerCustomer(Customer customer){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection(JDBC_URL, USERNAME,PASSWORD);
			
			String insertQuery = "insert into TBL_CUSTOMER (customername, customercontactnumber, customeraddress, customeremailid, customerpassword) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getContactNumber());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPassword());


			
			int count = ps.executeUpdate();
			
			if (count>0){
				return true;
				
			}
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if (con != null){
				try {
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
					
				}
				
			}
		}
		
		
		return false;
		
	}
	
	
	
	public List<Customer> getCustomerslist(){
		List<Customer> customers = new ArrayList<Customer>();
		
		try{
			System.out.println("safasfsafas1");
			System.out.println(con);
			

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection(JDBC_URL, USERNAME,PASSWORD);

			System.out.println("safasfsafas2");
			
			String selectQuery = "select * from TBL_CUSTOMER";
			PreparedStatement ps = con.prepareStatement(selectQuery);
			
			
			
			rs = ps.executeQuery();
			System.out.println("safasfsafas");
			
			while(rs.next()){
				
				Customer customer = new Customer();
				customer.setPassword(rs.getString("CUSTOMERPASSWORD"));
				customer.setName(rs.getString("CUSTOMERNAME"));
				customer.setContactNumber(rs.getString("CUSTOMERCONTACTNUMBER"));
				customer.setAddress(rs.getString("CUSTOMERADDRESS"));
				customer.setEmail(rs.getString("CUSTOMEREMAILID"));

				
				customers.add(customer);
				
			}
		System.out.println("length in dao is : " + customers.size());
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
			System.out.println("catched1?");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println("catched?");
			
		}
		finally{
			if (con != null){
				try {
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
					
				}
				
			}
		}
		System.out.println("printing size "+ customers.size());
		return customers;
		
	}

}

