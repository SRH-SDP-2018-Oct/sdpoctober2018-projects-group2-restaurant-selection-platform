package com.srh.rsp;

import java.util.Scanner;
import LogException.*;

public class Filters {
	WriteExceptionToFile log = new WriteExceptionToFile();

	protected void CuisineFilter(String location) {
		// Fetch cuisine types from db
	}

	protected void DistanceFilter(String location) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a ditance radius in kms: ");
		try {
			double distance = Double.parseDouble(input.nextLine());
			// Filter restaurants based on distance entered
		} catch (NumberFormatException e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		input.close();
	}

	protected void TypeFilter(String location) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter restaurant type: ");
		String type = input.nextLine();
		// FIlter restaurants based on type
		input.close();
	}

	protected void RatingsFilter(String location) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter restaurant ratings: ");
		try {
		double rating = Double.parseDouble(input.nextLine());
		// FIlter restaurants based on ratings
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
		input.close();
	}
}