package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Transcript t1 = new Transcript("Bs Computer Science", null);
		Classroom c1 = new Classroom("Mc Laughing Bldg", "M105", null);
		Student s1 = new Student(" 000-61-0001", "Anna", "Lynn", "Smith", 3.46F, LocalDate.of(2020, 05, 28));
	List<Student> students = Arrays.asList(s1);
		s1.setClassroom(c1);
		s1.setTranscript(t1);
		c1.setStudents(students);

		Student stuSaved = saveStudent(s1);
		System.out.println(stuSaved);

	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
}