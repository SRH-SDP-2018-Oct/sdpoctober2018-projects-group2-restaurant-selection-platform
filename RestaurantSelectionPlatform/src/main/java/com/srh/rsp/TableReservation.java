package com.srh.rsp;
import java.util.Scanner;


public class TableReservation {

	 public void ReserveTable() {


		int total_seats_available=50;
		int total_tables_available=15;
		int reserved_table_number_1= 1;
		int reserved_table_number_5=5;
		int reserved_table_number_7=7;
		int reserved_table_number_11=11;
		int reserved_table_number_14=14;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a table number");
		int num = scan.nextInt();

		if(num==reserved_table_number_1||num==reserved_table_number_5||num==reserved_table_number_7||num==reserved_table_number_11||num==reserved_table_number_14) 
		{
			System.out.println("Sorry table already reserved , Please choose another table!!");
			System.exit(1);
		}
		if ((num<=0) ||(num > total_tables_available))
		{
			System.out.println("Sorry booking not possible,Please enter a valid table number");
			System.exit(1);
		}

		else
		{
			System.out.println("Proceed to select the number of seats\n");
		}


		
		Scanner scan1=new Scanner(System.in);
		System.out.println("Enter number of seats to book");
		int num2 = scan1.nextInt();
		int seats_left;
		seats_left=  total_seats_available-num2;
		System.out.println("seats left:"+seats_left); 
		System.out.println('\n');

		if (num2<=0)  
		{
			System.out.println(" Please enter a valid seat number");
			System.exit(1);
		}

		if (num2>total_seats_available)
		{
			System.out.println("Sorry booking full");
			System.exit(1);
		}    

		else
		{
			System.out.println("Thank you,Your booking is confirmed!!");
			System.out.println("1.Booking ID:******\n2.Booking status:Confirmed" );
			System.out.println("3.Table number:"+num) ;
			System.out.println("4.Number of seats:"+num2);
		}
		Scanner scan4=new Scanner(System.in);
		System.out.println("Enter a table number");
		int num3 = scan.nextInt();
        if(num3==num)
        {
        	System.out.println("Sorry table already reserved , Please choose another table!!");
        	System.exit(1);
        }
		Scanner scan5=new Scanner(System.in);
		System.out.println("Enter number of seats to book");
		int num4 = scan.nextInt();
		if(num4>total_seats_available) 
		{
			System.out.println("Sorry booking full");
		}

		else
		{
			System.out.println("Thank you,Your booking is confirmed!!");
			System.out.println("1.Booking ID:******\n2.Booking status:Confirmed" );
			System.out.println("3.Table number:"+num) ;
			System.out.println("4.Number of seats:"+num4);
		}
	}
}








