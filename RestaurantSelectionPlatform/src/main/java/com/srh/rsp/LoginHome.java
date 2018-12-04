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
		try {
			int choice = Integer.parseInt(input.nextLine());
			LoginHomeSelection(choice);
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			ConsoleMenu();
		}
	}

	private void LoginHomeSelection(int choice) {
		switch (choice) {
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
	}

	private void Login() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Credentials");
		System.out.print("Email: ");
		try {
			String eMail = input.nextLine();
			FormatValidation EmailFormat = new FormatValidation();
			if (EmailFormat.validateEmailAddress(eMail)) {
				Console console = System.console();
				char[] password = console.readPassword("Password: ");
				String passWord = String.valueOf(password);

				LoginSession session = new LoginSession();
				session.Login(eMail, passWord);
				input.close();
			} else
				System.out.println("Enter a valid email id");
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			Login();
		}
	}

	private void Register() {
		Scanner input = new Scanner(System.in);
		RegistrationDetails userDetails = new RegistrationDetails();
		System.out.println("Enter Details Below:");
		System.out.print("Your Name: ");
		try {
			Console console = System.console();
			userDetails = enterDetails(userDetails, console);

			char[] confirmPassword = console.readPassword("Re-enter Password: ");
			String confirmPassWord = String.valueOf(confirmPassword);

			if (PassWordMatch(userDetails, confirmPassWord)) {
				System.out.println("Please select your role:");
				SelectRole(userDetails);
			} else
				System.out.println("Passwords do not match");
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			Register();
		}
	}

	private RegistrationDetails enterDetails(RegistrationDetails userDetails, Console console) {
		Scanner input = new Scanner(System.in);
		FormatValidation EmailFormat = new FormatValidation();
		FormatValidation ContactNumFormat = new FormatValidation();
		userDetails.personName = input.nextLine();
		System.out.print("Email: ");
		userDetails.eMail = input.nextLine();
		if(EmailFormat.validateEmailAddress(userDetails.eMail)){		
		System.out.print("Contact No: ");
			if(ContactNumFormat.validateMobileNumber(userDetails.contactNumber)) {
				userDetails.contactNumber = input.nextLine();
				char[] password = console.readPassword("Select Password: ");
				userDetails.passWord = String.valueOf(password);
				return userDetails;
			}
			else {
				System.out.println("Kindly enter a valid contact number\n Please exit and try again");
				return userDetails;
			}
		}
			else {
				System.out.println("enter a valid email id\n Please exit and try again");
				return userDetails;
			}
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
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1:
			case 2:
			case 3:
				user.NewRegistration(userDetails, choice);
				break;
			case 0:
				ExitApp();
				break;
			default:
				System.out.println("Wrong input");
			}
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			SelectRole(userDetails);
		}
	}

	private boolean PassWordMatch(RegistrationDetails userDetails, String confirmPassWord) {
		if (userDetails.passWord.equals(confirmPassWord))
			return true;
		else
			return false;
	}

	private void ExitApp() {
		System.exit(0);
	}
}
