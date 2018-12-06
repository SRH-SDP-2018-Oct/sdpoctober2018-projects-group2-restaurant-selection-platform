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
		} catch (NumberFormatException e) {
			log.appendToFile(e);
		}
		input.close();
	}

	protected void TypeFilter(String location) {

	}

	protected void RatingsFilter(String location) {

	}
}