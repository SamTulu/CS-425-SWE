package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student implements Comparable{

	protected Long studentID;
	protected String name;
	protected LocalDate dateOfAddmission;

	public Student() {

	}

	public Student(Long studentID, String name, LocalDate dateOfAddmission) {

		this.studentID = studentID;
		this.name = name;
		this.dateOfAddmission = dateOfAddmission;
	}

	public Long getSrudentID() {
		return this.studentID;
	}

	public String getName() {
		return this.name;
	}

	public LocalDate getDateOfAddmission() {
		return this.dateOfAddmission;
	}

	public int compareTo(Object o) {
		Student s = (Student) o;
		return this.name.compareTo(s.name);
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", dateOfAddmission=" + dateOfAddmission + "]";
	}
     
     
}
