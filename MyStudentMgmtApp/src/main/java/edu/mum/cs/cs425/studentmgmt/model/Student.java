package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long studentId;

	@Column(name = "student_number", unique = true, nullable = false)
	private String studentNumber;
	@NotBlank(message = "First name is required")
	@Column(name = "first_name", nullable = false)
	private String firstname;
	@Column(name = "middle_name", nullable = true)
	private String middleName;

	@NotBlank(message = "Last  name is required")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	private Float cgpa;

	@Column(name = "admission_date")
	@DateTimeFormat(pattern = "yyyy -mm- dd")
	private LocalDate admissionDate;

	@OneToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "transcript_id", nullable = false)
	private Transcript transcript;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "classroom_id", nullable = false)
	private Classroom classroom;

	public Student() {
		super();
	}

	public Student(Long studentId, String studentNumber, @NotBlank(message = "First name is required") String firstname,
			String middleName, @NotBlank(message = "Last  name is required") String lastName, Float cgpa,
			LocalDate admissionDate, Transcript transcript, Classroom classroom) {
		super();
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstname = firstname;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.admissionDate = admissionDate;
		this.transcript = transcript;
		this.classroom = classroom;
	}

	public Student(String studentNumber, @NotBlank(message = "First name is required") String firstname,
			String middleName, @NotBlank(message = "Last  name is required") String lastName, Float cgpa,
			LocalDate admissionDate, Classroom classroom) {
		super();
		this.studentNumber = studentNumber;
		this.firstname = firstname;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.admissionDate = admissionDate;
		this.classroom = classroom;
	}

	public Student(String studentNumber, @NotBlank(message = "First name is required") String firstname,
			String middleName, @NotBlank(message = "Last  name is required") String lastName, Float cgpa,
			LocalDate admissionDate, Transcript transcript, Classroom classroom) {
		super();
		this.studentNumber = studentNumber;
		this.firstname = firstname;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.admissionDate = admissionDate;
		this.transcript = transcript;
		this.classroom = classroom;
	}

	public Student(String studentNumber, @NotBlank(message = "First name is required") String firstname,
			String middleName, @NotBlank(message = "Last  name is required") String lastName, Float cgpa,
			LocalDate admissionDate, Transcript transcript) {
		super();
		this.studentNumber = studentNumber;
		this.firstname = firstname;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.admissionDate = admissionDate;
		this.transcript = transcript;
	}

	public Student(String studentNumber, @NotBlank(message = "First name is required") String firstname,
			String middleName, @NotBlank(message = "Last  name is required") String lastName, Float cgpa,
			LocalDate admissionDate) {
		super();
		this.studentNumber = studentNumber;
		this.firstname = firstname;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.admissionDate = admissionDate;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getCgpa() {
		return cgpa;
	}

	public void setCgpa(Float cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [studentId=%s, studentNumber=%s, firstname=%s, middleName=%s, lastName=%s, cgpa=%s, admissionDate=%s, transcript=%s, classroom=%s]",
				studentId, studentNumber, firstname, middleName, lastName, cgpa, admissionDate, transcript, classroom);
	}

}
