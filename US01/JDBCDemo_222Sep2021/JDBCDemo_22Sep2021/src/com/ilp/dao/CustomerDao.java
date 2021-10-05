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
	
	public static final String JDBC_URL="jdbc:derby:C:\\Users\\1260655\\MyDB17Sep2021;create=true";
	public static final String USERNAME="test";
	public static final String PASSWORD="test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
	public boolean registerCustomer(Customer customer){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String insertQuery="insert into tbl_customer values(?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setInt(3, customer.getAge());
			ps.setString(4, customer.getCity());
			
			int count=ps.executeUpdate();
			
			if(count>0){
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
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		}
		
		
		
		return false;
		
	}
	
	
	public List<Customer> searchCustomersByCity(String city){
		
		List<Customer> customers= new ArrayList<Customer>();
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String selectQuery="select * from tbl_customer where city=?";
			PreparedStatement ps= con.prepareStatement(selectQuery);
			
			
			ps.setString(1, city);
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				Customer customer= new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMERID"));
				customer.setCustomerName(rs.getString("CUSTOMERNAME"));
				customer.setAge(rs.getInt("AGE"));
				customer.setCity(rs.getString("CITY"));
				
				customers.add(customer);
				
				
			}
			
		
			
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		}
		
		return customers;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
