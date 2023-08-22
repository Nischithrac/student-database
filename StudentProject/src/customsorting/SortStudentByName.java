package customsorting;

import java.util.Comparator;

import student.Student1;

public class SortStudentByName implements Comparator<Student1> {

	@Override
	public int compare(Student1 x, Student1 y) {
		// TODO Auto-generated method stub
		return x.getName().compareTo(y.getName());
	}
	

}

//x--inserted current object
//y---already exiting  Object