import java.util.Scanner;

public class ConsoleLogin {
	public void Person() {
		System.out.println("Login As:");
		System.out.println("1. Owner \n2. Customer");
		System.out.print("Enter Choice: ");
		Scanner input = new Scanner(System.in);
		int choice = Integer.parseInt(input.nextLine());
		switch(choice) {
		case 1:
			OwnerPage();
			break;
		case 2:
			CustomerPage();
			break;
		default:
			System.out.println("Wrong input");
		}
		input.close();	
	}
	
	private void OwnerPage() {
		System.out.println("1. Login \n2. Register");
		System.out.print("Enter Choice: ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			OwnerLogin();
			break;
		case 2:
			OwnerRegister();
			break;
		default: 
			System.out.println("Wrong input");
		}
		input.close();
	}

	private void CustomerPage() {
		System.out.println("1. Login \n2. Register");
		System.out.print("Enter Choice: ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			CustomerLogin();
			break;
		case 2:
			CustomerRegister();
			break;
		default: 
			System.out.println("Wrong input");
		}
		input.close();
	}
	
	private void OwnerLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Credentials");
		System.out.print("Username: ");
		String userName = input.nextLine();
		System.out.print("Password: ");
		String passWord = input.nextLine();
		
		OwnerLoginCheck(userName, passWord);
		
		input.close();
	}
		
	private void OwnerRegister() {
		OwnerRegistrationDetails();
		OwnerLogin();
	}
	
	private void OwnerRegistrationDetails() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Details Below:");
		System.out.println("Name: ");
		String ownerName = input.nextLine();
		System.out.println("UserName: ");
		String userName = input.nextLine();
		System.out.println("Email: ");
		String eMail = input.nextLine();
		System.out.println("Contact No: ");
		String contactNumber = input.nextLine();
		System.out.print("Password: ");
		String passWord = input.nextLine();
		
		RegisterOwner(ownerName,userName,eMail,contactNumber,passWord);
		input.close();
	}
	
	private void OwnerLoginCheck(String userName, String passWord) {
		ConsoleMenu ownerMenu = new ConsoleMenu();
		ownerMenu.OwnerMenu();
	}
	
	private void CustomerLogin() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Credentials");
		System.out.print("Username: ");
		String userName = input.nextLine();
		System.out.print("Password: ");
		String passWord = input.nextLine();
		
		CustomerLoginCheck(userName, passWord);
		input.close();
	}
	
	private void CustomerRegister() {
		CustomerRegistratonDetails();
		CustomerLogin();
	}
	
	private void CustomerRegistratonDetails() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Details Below:");
		System.out.println("Name: ");
		String customerName = input.nextLine();
		System.out.println("UserName: ");
		String userName = input.nextLine();
		System.out.println("Email: ");
		String eMail = input.nextLine();
		System.out.println("Contact No: ");
		String contactNumber = input.nextLine();
		System.out.print("Password: ");
		String passWord = input.nextLine();
		
		RegisterCustomer(customerName,userName,eMail,contactNumber,passWord);
		input.close();
	}
	
	private void CustomerLoginCheck(String userName, String passWord) {
		ConsoleMenu customerMenu = new ConsoleMenu();
		customerMenu.CustomerMenu();
	}
	
	private void RegisterOwner(String ownerName,String userName,String eMail,String contactNumber,String passWord) {
		System.out.println("Successfully Registered");
	}
	
	private void RegisterCustomer(String ownerName,String userName,String eMail,String contactNumber,String passWord) {
		System.out.println("Successfully Registered");
	}
}
