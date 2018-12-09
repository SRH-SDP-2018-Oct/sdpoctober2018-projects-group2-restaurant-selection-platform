package srh.com.rsp.CustomerFunctionalities;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


class TableReservation {

		static void TableNumber() 
		{
			int reserved_table_number_1 = 1;
			int reserved_table_number_5 = 5;
			int reserved_table_number_7 = 7;
			int reserved_table_number_11 = 11;
			int total_tables_available = 15;
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a table number");
			int num = scan.nextInt();

			if (num == reserved_table_number_1 || num == reserved_table_number_5 || num == reserved_table_number_7
					|| num == reserved_table_number_11) {
				System.out.println("Sorry table already reserved , Please choose another table!!");
				System.exit(1);
			}
			if ((num <= 0) || (num > total_tables_available)) {
				System.out.println("Sorry booking not possible,Please enter a valid table number");
				System.exit(1);
			}

			else {
				System.out.println("Table number:" + num);

			}
		}

		static void SeatNumber() {

			int total_seats_available = 50;
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter number of seats to book");
			int num2 = scan1.nextInt();
			int seats_left;
			seats_left = total_seats_available - num2;
			System.out.println("seats left:" + seats_left);
			System.out.println('\n');

			if (num2 <= 0) {
				System.out.println(" Please enter a valid seat number");
				System.exit(1);
			}

			if (num2 > total_seats_available) {
				System.out.println("Sorry booking full");
				System.exit(1);
			}

			else {

				System.out.println("Number of seats:" + num2);
			}

		}

		static void StatusConfirmation() {
			
			System.out.println("Thank you,Your booking is confirmed!!");
			System.out.println("Booking ID:******\n Booking status:Confirmed");
		}
		

			public static void main(String args[]) {
				TableNumber();
			    SeatNumber();
			    Scanner input1 = new Scanner(System.in);
				 System.out.print("Enter the date of reservation (DD:MM:YYYY) ");
				 String Correctformat="[1-31]:[0-12]:[0-2025]";
				 String date = input1.nextLine();
				 if(date==Correctformat) {
					 System.out.println("reserved ar:"+date);
				 }
				 else
				 {
					 System.out.println("enter correct format");
					 System.exit(1);
				 }
			     Scanner input = new Scanner(System.in);
				 System.out.print("Enter the time of reservation (hh:mm aa): ");
				 String time = input.nextLine();
				 StatusConfirmation();
				 System.out.println("Your Reservation confirmed at:"+date);
				 System.out.println("Your Reservation confirmed at:"+time);
				    
			    
			}
		}


