package tcs.com.input;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerInput {

	public static void main(String[] args) {
		
		boolean nameIsCorrect, numberIsCorrect, addressIsCorrect, emailIsCorrect;
		Scanner inputScanner = new Scanner(System.in);
		
		boolean nameIsCorrect = false, numberIsCorrect = false, 
				addressIsCorrect = false, emailIsCorrect = false;
		Scanner inputScanner = new Scanner(System.in);
		String name = null, contactNumber = null, address = null, email = null;
		
		while (!nameIsCorrect) {
			System.out.println("Enter your name");
			name = inputScanner.nextLine();
			nameIsCorrect = nameValidator(name);
		}
		
		while(!numberIsCorrect) {
			System.out.println("Enter your contact number");
			contactNumber = inputScanner.nextLine();
			numberIsCorrect = contactNumberValidator(contactNumber);
		}
		
		
		while(!addressIsCorrect) {
			System.out.println("Enter your address");
			address = inputScanner.nextLine();
			addressIsCorrect = nameValidator(address);
		}
		
		System.out.println(
				"If you have an email ID, plase enter it here. " + 
				"\n if you do not have one, please press N");
			email = inputScanner.nextLine();
		
		if (email == "N") {
			System.out.println("Registering without email");
			System.out.println("Registered with following information: " 
								+ "\nName:" + name + "\nContact Number:"  
								+	contactNumber + "\nAddress:" + address
								);
		} else {
			emailIsCorrect = emailValidator(email);
			
			if(!emailIsCorrect)
			
			System.out.println("Registering with email");
			System.out.println("Registered with following information: " 
					+ "\nName:" + name + "\nContact Number:"  
					+	contactNumber + "\nAddress:" + address + "\nEmail:" + email
					);
			inputScanner.close();
		} 
		

	}
	
	public static boolean nameValidator(String name) {
		boolean nameCheck = true;
		Pattern pattern = Pattern.compile("[^a-ö]+");
		Matcher m = pattern.matcher(name);
		if(m.matches()) {
			nameCheck = false;
			System.out.println("Invalid input, no numbers allowed in names!");
		}
		if(name.length() < 1) {
			nameCheck = false;
			System.out.println("Invalid input, the field is empty!");
		}
		return nameCheck;
	}
	
	public static boolean contactNumberValidator(String number) {
		boolean numberCheck = true;
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher m = pattern.matcher(number);
		if(number.length() < 3) {
			numberCheck = false;
			System.out.println("Invalid input, number is too short");
		}
		if(m.matches() == false) {
			numberCheck = false;
			System.out.println("Invalid contact number, no numbers found!");
		}
		return numberCheck;
	}
	
	public static boolean emailValidator(String email) {
		boolean emailCheck = true;
		if(email.length() < 3) {
			emailCheck = false;
			System.out.println("Invalid input, email is too short");
		}
		Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+"
				+ "(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*"
				+ "[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
		
		Matcher m = p.matcher(email);
		if(m.matches() == false) {
			emailCheck = false;
			System.out.println("Invalid email format!");
		}
		return emailCheck;
	}
	
}
