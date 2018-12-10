package com.srh.rsp;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.srh.rsp.Validations.FormatValidation;

import LogException.WriteExceptionToFile;

public class LoginHome {
	WriteExceptionToFile log = new WriteExceptionToFile();

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
			log.appendToFile(e);
		}
	}
	
	public void afterRegistration() {
		System.out.println("-----------------Welcome to Restaurant Selection Platform-----------------");
		System.out.println("Please login");
		
		Login();
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
				String passWord = enterPassword();
				LoginSession session = new LoginSession();
				session.Login(eMail, passWord);
				input.close();
			} else {
				System.out.println("Enter a valid email id");
				Login();
			}
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	public String enterPassword() {
		String message = "Enter password";
		if (System.console() == null) { // inside IDE like Eclipse or NetBeans
			final JPasswordField pf = new JPasswordField();
			return JOptionPane.showConfirmDialog(null, pf, message, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(pf.getPassword()) : "";
		} else
			return new String(System.console().readPassword("%s> ", message));
	}

	private void Register() {
		Scanner input = new Scanner(System.in);
		RegistrationData userDetails = new RegistrationData();
		System.out.println("Enter Details Below:");
		System.out.print("Your Name: ");
		try {
			userDetails = enterDetails(userDetails);
			FormatValidation validation = new FormatValidation();
			String confirmPassWord = null;
			if (userDetails != null)
				confirmPassWord = enterPassword();

			if (validation.PassWordMatch(userDetails, confirmPassWord)) {
				System.out.println("Please select your role:");
				SelectRole(userDetails);
			} else
				System.out.println("Passwords do not match");
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private RegistrationData enterDetails(RegistrationData userDetails) {
		Scanner input = new Scanner(System.in);
		FormatValidation validation = new FormatValidation();
		userDetails.personName = input.nextLine();
		System.out.print("Email: ");
		userDetails.eMail = input.nextLine();
		if (userDetails.eMail != null && validation.validateEmailAddress(userDetails.eMail)) {
			System.out.print("Contact No: ");
			userDetails.contactNumber = input.nextLine();
			if (userDetails.contactNumber != null && validation.validateMobileNumber(userDetails.contactNumber)) {
				userDetails.passWord = enterPassword();
				return userDetails;
			} else {
				System.out.println("Kindly enter a valid contact number");
				return null;
			}
		} else {
			System.out.println("enter a valid email id");
			return null;
		}
	}

	private void ProceedAsGuest() {
		MainMenu startPage = new MainMenu();
		startPage.CustomerMainMenu();
	}

	private void SelectRole(RegistrationData userDetails) {
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
			log.appendToFile(e);
		}
	}

	private void ExitApp() {
		System.exit(0);
	}
}
