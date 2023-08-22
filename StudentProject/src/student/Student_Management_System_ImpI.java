package student;
import java.beans.beancontext.BeanContextContainerProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class Student_Management_System_ImpI  implements Student_Management_System{

	Scanner scan=new Scanner(System.in);
	Map<String, Student1>db=new LinkedHashMap<>();
	@Override
	public void addStudet() {
		System.out.println("Enter the age: ");
		int age=scan.nextInt();

		System.out.println("Enter the name: ");
		String name=scan.next();

		System.out.println("enter the student marks :");
		int marks=scan.nextInt();

		Student1 s=new Student1(age,name,marks);

		db.put(s.getId(), s);

		System.out.println("Student Record Inserted Succesfull");
		System.out.println("your Student id is:"+s.getId());
	}

	@Override
	public void displayStudet() {
		//accepting Student id ---->NCB101
		System.out.println("Enter the student Id: ");
		String id=scan.next();//	String id=scan.next().toUpperCase();
		id=	id.toUpperCase();
		//Checking if id present or not (id==key) ----->containsKey()
		if( db.containsKey(id) ) {

			System.out.println("Student Records Found!!");
			System.out.println("Student Details are as followes");
			Student1 std=db.get(id);// get the Student obj based on id
			System.out.println("id :"+std.getId());
			System.out.println("Age :"+std.getAge());
			System.out.println("Name :"+std.getName());
			System.out.println("Marks :"+std.getMarks());
			//Printing reference variable as toString() is Overridden
			//System.out.println(std);

		}else {
			try {
				String message="Student with id :"+id+" is not found!!";
				throw new   StudentNotException(message);

			} catch (Exception e) {
				System.out.println( e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudets() {
		if(!db.isEmpty()) {//if checking db is not Empty

			System.out.println("Student records are as follows");
			System.out.println("------------------------");

			Set<String>keys=db.keySet();
			for(String key :keys) {
				Student1 s=db.get(key);
				System.out.println(s);

			}

		} else 
		{
			try {
				String messge="No student Recoreds to Display!!";
				throw new StudentNotException(messge);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void removeStudet() {
		//Accepting Student id---->S
		System.out.println("Enter the Student id :");
		String id=scan.next();//	String id=scan.next().toUpperCase();
		id=	id.toUpperCase();
		//contain
		if(db.containsKey(id)) {
			System.out.println("Student Records Found");
			System.out.println(db.get(id));//printing Student object
			db.remove(id);//removing the enter the (key & value)
			System.out.println("Student recoreds Deleted Successfully!");
		}	else {
			try {
				String message="Student records "+id+" is not found";
				throw new StudentNotException  (message);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudet() {
		if(!db.isEmpty()) {
			System.out.println("Number of student records: "+db.size());
			db.clear();
			System.out.println("All student recored deleteds successfully!");
		}
		else {


			try {
				String message="Student records  to deleted";
				throw new StudentNotException  (message);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudet() {
		System.out.println("Enter Student id: ");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Student Records found");
			Student1 std=db.get(id);//Getting value (student Object)
			System.out.println("1:update Age\2:Upadate Name\n3:Upadate marks\n Enter the Choice");
			int choice=scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Age ");
				int age=scan.nextInt();//std.setAge(scan.nexint());
				std.setAge(age);//
				System.out.println("Age upadated successfully!");
				break;
			case 2:
				System.out.println("Enter the Name ");
				String name=scan.next();//std.setAge(scan.nextLine());
				std.setName(name);
				System.out.println("Name upadated successfully!");
				break;
			case 3:
				System.out.println("Enter the Marks ");
				int Marks=scan.nextInt();//std.setAge(scan.nextInt());
				std.setMarsks(Marks);
				System.out.println("Marks upadated successfully!");
				break;

			default:
				try {
					String message="Ivalid choice ,enter the Valid choice";
					throw new InvlidChoiceExcption (message);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
		else {
			try {
				String message=" Student with id: "+id+" Is not found";
				throw new InvlidChoiceExcption(message);


			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudet() {


	}

	@Override
	public  void sortStudet() {
		/**
		 * we cannot sort Map based on values ,therefore we are getting 
		 * the value from map & Sorting it inside list so that we can sort
		 * list using -->Collection .sort(list,sorting logic object);
		 */
		//Reference of list & object  of ArrayList Sorting Student Object
		List<Student1>list=new ArrayList<>();
		//		Converting Map into Set ,Which Stores Keys(id)
		Set<String>keys=db.keySet();
		//trversing Keys (id)
		for(String key:keys) {
			//Getting values (Student Object )& adding it into List
			list.add(db.get(key));
		}

		System.out.println("1.Sort Student By ID\2.Sort Student By Age");
		System.out.println("3.Sort Student By Name\n4.Sort Student By Marks");
		System.out.println("Enter the choice");
		int choice=scan.nextInt();
		switch (choice) {
		case 1:

			Collections.sort(list,new SortStudentById());
			for(Student1 s:list) {
				System.out.println(s);
			}

			break;

		case 2:

			Collections.sort(list,new SortStudentByAge());
			for(Student1 s:list) {
				System.out.println(s);
			}


			break;
		case 3:

			Collections.sort(list,new SortStudentByName());
			for(Student1 s:list) {
				System.out.println(s);
			}


			break;
		case 4:

			Collections.sort(list,new SortStudentByMarks());
			for(Student1 s:list) {
				System.out.println(s);
			}


			break;
		default:
			try {
				String messge="Invalid choice,enter the valid Choice";
				throw new InvaildChoicException(messge);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void findStudentWithHihestMarks() {
		List<Student1>list=new ArrayList<Student1>();
		Set<String>keys=db.keySet();
		for(String key:keys) {
			list.add(db.get(key));//adding Student Object from map List ArrayList();

		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Stdeunt with Highest Marks");
		System.out.println(list.size()-1);



	}

	@Override
	public void findStudentWithLowstMarks() {
		List<Student1>list=new ArrayList<Student1>();
		Set<String>keys=db.keySet();
		for(String key:keys) {
			list.add(db.get(key));

		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Stdeunt with lowest Marks");
		System.out.println(list.get(0));



	}

}
