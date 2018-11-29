package com.srh.rsp;
import java.io.Console;
import java.util.Scanner;

public class LoginHome {
	public void ConsoleMenu() {
		System.out.println("-----------------Welcome to Restaurant Selection Platform-----------------");
		System.out.println("Select an option:");
		System.out.println("1. Login \n2. Register \n3. Continue as guest \n0. Exit");
		System.out.print("Enter Choice: ");
		Scanner input = new Scanner(System.in);
		int choice = Integer.parseInt(input.nextLine());
		switch(choice) {
		case 1:
			Login();
			break;
		case 2:
			Register();
			break;
		case 3:
			ProceedAsGuest();
			break;
		case 0:
			ExitApp();
			break;
		default:
			System.out.println("Wrong input");
		}
		input.close();
	}
	
	private void Login() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Credentials");
		System.out.print("Username: ");
		String userName = input.nextLine();
		Console console = System.console();
	    char[] pw = console.readPassword("Password: ");
	    String passWord = String.valueOf(pw);
		
	    LoginSession session = new LoginSession();
	    session.Login(userName, passWord);
		input.close();
	}

	private void Register() {
		Scanner input = new Scanner(System.in);
		RegistrationDetails userDetails = new RegistrationDetails();
		System.out.println("Enter Details Below:");
		System.out.print("Your Name: ");
		userDetails.personName = input.nextLine();
		System.out.print("UserName: ");
		userDetails.userID = input.nextLine();
		System.out.print("Email: ");
		userDetails.eMail = input.nextLine();
		System.out.print("Contact No: ");
		userDetails.contactNumber = input.nextLine();
		System.out.print("Password: ");
		userDetails.passWord = input.nextLine();
		
		System.out.println("Please select your role:");
		SelectRole(userDetails);
		
		input.close();
	}
	
	private void ProceedAsGuest() {
		MainMenu startPage = new MainMenu();
		startPage.CustomerMainMenu();
	}
	
	private void SelectRole(RegistrationDetails userDetails) {
		Scanner input = new Scanner(System.in);
		UserRegistration user = new UserRegistration();
		System.out.println("1. Customer \n2. Restaurant Owner \n3. Both \n0. Exit");
		System.out.print("Enter choice: ");
		int choice = Integer.parseInt(input.nextLine());
		switch(choice) {
		case 1:
			user.CustomerRegistration(userDetails);
			break;
		case 2:
			user.OwnerRegistration(userDetails);
			break;
		case 3:
			user.UserRegistraion(userDetails);
			break;
		case 0:
			ExitApp();
			break;
		default:
			System.out.println("Wrong input");
		}
		input.close();
	}
	
	private void ExitApp() {
		System.exit(0);
	}
}

