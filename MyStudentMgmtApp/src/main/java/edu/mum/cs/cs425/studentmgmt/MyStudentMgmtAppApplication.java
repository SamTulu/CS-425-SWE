package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Student s1 = new Student(" 000-61-0001", "Anna", "Lynn", "Smith", 3.46F, LocalDate.of(2020, 05, 28));

		Student stuSaved = saveStudent(s1);
		System.out.println(s1);

	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
}