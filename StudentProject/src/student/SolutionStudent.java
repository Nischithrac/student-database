
package student;

import java.util.Scanner;

public class  SolutionStudent {
	public static void main(String[] args) {
		System.out.println("Wellcome to Student Database Projet");
		System.out.println("--------------------------------------");
		Scanner scan=new Scanner(System.in);
		Student_Management_System sms=new Student_Management_System_ImpI() ;
		while(true) {
			System.out.println("1.Addstudent\n2.DisplayStudent\n3.DisplayAllStududent\n4.RemoveStudent");
			System.out.println("5.RemoveAllStudent\n6.UpadateStudent\n7.CountStudent\n8.SotStudent");
			System.out.println("9.FindStudentHeigetstMarks\n10.FindStudentLowestMarks\n11.exit");
			System.out.println("----------------------------------------------------------");
			System.out.println("Enetr the choice");
			System.out.println("-----------------------------------------------------------");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				sms.addStudet();
				break;
			case 2:
				sms.displayStudet();
				break;
			case 3:
				sms.displayAllStudets();

				break;
			case 4:
				sms.removeStudet();

				break;

			case 5:
				sms.removeAllStudet();

				break;

			case 6:
				sms.updateStudet();

				break;

			case 7:
				sms.countStudet();

				break;

			case 8:
				sms.sortStudet();;

				break;
			case 9:
				sms.findStudentWithHihestMarks();

				break;
			case 10:
				sms.findStudentWithLowstMarks();

				break;
			case 11:
				System.out.println("Thakyou!");
				System.exit(0);

				break;
			default:
				try {
					String messge=" InvaildChoicException";
					throw new  InvaildChoicException(messge );
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
	}
}


