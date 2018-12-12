package srh.com.rsp.CustomerFunctionalities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.srh.rsp.LoginSession;
import com.srh.rsp.dbAccess.RestaurantReservationCRUD;

import LogException.WriteExceptionToFile;

public class TableReservation {
	WriteExceptionToFile log = new WriteExceptionToFile();
	ReservationInputData data = new ReservationInputData();

	public void reservationRequest() {
		Scanner input = new Scanner(System.in);
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		System.out.println("-----------------Welcome to Restaurant Selection Platform-----------------");
		System.out.println("-----------------Reservation Request-----------------");
		System.out.print("\nPlease enter the date in yyyy-MM-dd format: ");
		try {
			java.util.Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
			data.date = new java.sql.Date(fromDate.getTime());
			System.out.print("Please enter FROM time in hh:mm format: ");
			data.timeFrom = new java.sql.Time(formatter.parse(input.nextLine()).getTime());
			System.out.print("Please enter TO time in hh:mm format: ");
			data.timeTo = new java.sql.Time(formatter.parse(input.nextLine()).getTime());
			System.out.print("Enter number of people: ");
			data.noOfPeople = Integer.parseInt(input.nextLine());

			MakeReservation();
		} catch (ParseException e) {
			System.out.println("\n**************Something went wrong**************\n");
			log.appendToFile(e);
			System.exit(0);
		} catch (NumberFormatException e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		} catch (Exception e) {
			System.out.println("\n**************Please enter a valid input**************\n");
			log.appendToFile(e);
		}
	}

	private void MakeReservation() {
		RestaurantReservationCRUD request = new RestaurantReservationCRUD();
		request.setRestaurantReservation(20L, LoginSession.userID, data.noOfPeople, "Processing", data.date,
				data.timeFrom, data.timeTo);
		LoginSession.loadMenu();
	}
}
