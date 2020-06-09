package edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi;

import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EregistrarwebapiApplication implements CommandLineRunner {
    @Autowired
private StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(EregistrarwebapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student();
        student.setFirstName("Samson");
        student.setInternational(true);
        student.setLastName("Tulu");
        student.setEnrollmentDate(LocalDate.now());
        student.setCGpa(3.6);
        student.setStudentNumber("0001");
        studentService.saveStudent(student);
    }
}
