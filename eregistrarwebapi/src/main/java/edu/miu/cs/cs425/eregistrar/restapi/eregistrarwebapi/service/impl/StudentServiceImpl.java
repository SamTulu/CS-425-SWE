package edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.service.impl;

import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.repository.IStudentRepository;
import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private IStudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchStudent(String searchString) {
        return studentRepository.findAllByStudentNumberEquals(searchString);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public void deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            studentRepository.deleteById(id);
        }
    }
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student editStudentById(Student editStudent, Long studentId) {
        return  studentRepository.findById(studentId)
                .map(studentToUpdate -> {
                    studentToUpdate.setStudentNumber(editStudent.getStudentNumber());
                    studentToUpdate.setFirstName(editStudent.getFirstName());
                    studentToUpdate.setMiddleName(editStudent.getMiddleName());
                    studentToUpdate.setLastName(editStudent.getLastName());
                    studentToUpdate.setcGpa(editStudent.getCGpa());
                    studentToUpdate.setEnrollmentDate(editStudent.getEnrollmentDate());
                    studentToUpdate.setInternational(editStudent.isInternational());
                    return studentRepository.save(studentToUpdate);
                }).orElseGet(() -> {
                    return studentRepository.save(editStudent);
                });
    }

}
