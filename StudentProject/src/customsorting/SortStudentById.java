package customsorting;

import java.sql.Connection;
import java.util.Comparator;

import student.Student1;

public class SortStudentById implements Comparator<Student1>{

	@Override
	public int compare(Student1 x, Student1 y) {
		
		return x.getId().compareTo(y.getId());
	}

}
