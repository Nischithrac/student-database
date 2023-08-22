package customsorting;

import java.util.Comparator;

import student.Student1;

public class SortStudentByMarks implements Comparator<Student1> {

	@Override
	public int compare(Student1 x, Student1 y) {
	
		return x.getMarks()-y.getMarks();
	}

}
