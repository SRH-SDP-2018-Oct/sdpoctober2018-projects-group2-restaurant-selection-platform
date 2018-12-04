package com.srh.rsp;

import java.util.Scanner;

public class UpdateProfile {
	public void UserProfile() {
		System.out.println("--------------Restaurant Selection Platform--------------");
		System.out.println("--------------Update Profile--------------");
		System.out.println("1. Edit Name \n2. Edit Email \n3. Edit ContactNumber \n0. Return to Main Menu");
		System.out.print("\nEnter choice: ");
		Scanner input = new Scanner(System.in);
		try {
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
			case 1:		//Edit name functionality
				break;
			case 2:		//Edit email functionality
				break;
			case 3:		//Edit contact number functionality
				break;
			case 0:
				MainMenu loadMenu = new MainMenu();
				loadMenu.CustomerMainMenu();
				break;
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
