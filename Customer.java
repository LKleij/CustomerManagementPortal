package tcs.customer;

public class Customer
{

	private String name;
	private int contactNumber;
	private String address;
	private int emailId;  // <--- OPTIONAL
	
	
	public Customer(String name, int contactNumber, String address, int emailId) 
	{
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
		this.emailId = emailId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getEmailId() {
		return emailId;
	}


	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	
	
	
	
	
}
