package edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.controller;

import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "eregistrar/api/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public List<Student> getStudentList() {
        return studentService.getStudents();
    }

    @PostMapping(value = "/add")
    public Student addNewStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(value = "/get/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping(value = "/edit/{studentId}")
    public Student editStudent(@Valid @RequestBody Student student, @PathVariable Long studentId) {
        return studentService.editStudentById(student, studentId);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
