package edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudents();

    List<Student> searchStudent(String searchString);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    Student getStudentById(Long id);

    Student editStudentById(Student editStudent, Long studentId);
}
