package Student_Database_Ex7;

import java.util.ArrayList;
import java.util.List;

import Student_Database_Ex7.Student;

public class StudentDAO {

	public List<Student> getAllStudents() {

		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student(40, "Baker", "Ginger", "Rumputie 10", 54120, "PULP"));
		studentList.add(new Student(30, "Bruce", "Jack", "Asematori 3", 00520, "HELSINKI"));
		studentList.add(new Student(20, "Clapp", "Eric", "Luuttutie", 54120, "PULP"));
		studentList.add(new Student(10, "Doe", "Diana", "Kuusikuja 6", 01200, "VANTAA"));

		return studentList;
	}

	public String getStudentsForGivenId(int id) {
		List<Student> studentList = new ArrayList<Student>();
		String output = "";
		studentList.add(new Student(40, "Baker", "Ginger", "Rumputie 10", 54120, "PULP"));
		studentList.add(new Student(30, "Bruce", "Jack", "Asematori 3", 00520, "HELSINKI"));
		studentList.add(new Student(20, "Clapp", "Eric", "Luuttutie", 54120, "PULP"));
		studentList.add(new Student(10, "Doe", "Diana", "Kuusikuja 6", 01200, "VANTAA"));
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId() == id) {
				output = id + " " + studentList.get(i).getFirstname() + " " + studentList.get(i).getLastname();
			}
		}
		return output;
	}
}
