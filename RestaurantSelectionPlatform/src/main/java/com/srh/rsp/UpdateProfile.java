package com.srh.rsp;

import java.util.Scanner;
import LogException.*;

public class UpdateProfile {
	WriteExceptionToFile log = new WriteExceptionToFile();

	public void UserProfile() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Update Profile--------------");
		System.out.println("1. Edit Name \n2. Edit Email \n3. Edit ContactNumber \n0. Return to Main Menu");
		System.out.print("\nEnter choice: ");
		makeSelection();
	}
	
	private void makeSelection() {
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1: editName();
				break;
			case 2: editEmail();
				break;
			case 3: editContact();
				break;
			case 0:
				MainMenu loadMenu = new MainMenu();
				loadMenu.CustomerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}
	
	private void editName() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter New name: ");
		String name = input.nextLine();
		// Edit name functionality
		
		input.close();
	}
	
	private void editEmail() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter new Email: ");
		String eMail = input.nextLine();
		// Edit email functionality
		
		input.close();
	}
	
	private void editContact() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter new Contact Number: ");
		String contact = input.nextLine();
		// Edit contact number functionality
		
		input.close();
	}
}
