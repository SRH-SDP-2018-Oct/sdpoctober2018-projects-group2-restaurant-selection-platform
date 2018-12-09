package srh.com.rsp.CustomerFunctionalities;
import java.util.Scanner;

	
	public class CustomerReview {
			
			
				static void Rating() {
				
				 System.out.println("Please rate our restaurant");
				 System.out.println("\n 1 Poor \n 2 Average \n 3 Good \n 4 Very good \n 5 Excellent");
				 System.out.println("Enter your choice" );
				Scanner input2 = new Scanner(System.in);
				 int choice = Integer.parseInt(input2.nextLine());
				 System.out.println("Thank you for the ratings\n"+input2 );
				}
				
				static void Feedback() {
					
			     System.out.println("Please provide your feedback");
			     Scanner input1 = new Scanner(System.in);
			     String Review= input1.nextLine();
			     System.out.println("Thank you for your feedback " );

				}
		}





