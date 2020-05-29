package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStudentRecordsMgmtApp {
	public static void printListOfStudents(Student[] students) {
		Arrays.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}

	}

	public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {

		List<Student> stus = new ArrayList<Student>();
		LocalDate currentDate = LocalDate.now();

		for (Student student : students) {
			LocalDate admissionDate = student.getDateOfAddmission();
			if (Period.between(admissionDate, currentDate).getYears() >= 30) {
				stus.add(student);
			}
		}

		return stus;
	}
	
	

	public static void main(String[] args) {
		Student[] stu = new Student[5];
		Student s1 = new Student(110001L, "Dave", LocalDate.parse("1951-11-18"));
		Student s2 = new Student(110002L, "Anna", LocalDate.parse("1990-12-07"));
		Student s3 = new Student(110003L, "Erica", LocalDate.parse("1974-01-31"));
		Student s4 = new Student(110004L, "Carlos", LocalDate.parse("2009-08-22"));
		Student s5 = new Student(110005L, "Bob", LocalDate.parse("1990-03-05"));

		stu[0] = s1;
		stu[1] = s2;
		stu[2] = s3;
		stu[3] = s4;
		stu[4] = s5;

		printListOfStudents(stu);
		
		System.out.println();
		
		System.out.println("************************************************");
		
		System.out.println(getListOfPlatinumAlumniStudents(stu));
	}
}
