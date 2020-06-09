package edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.repository;

import edu.miu.cs.cs425.eregistrar.restapi.eregistrarwebapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudentNumberEquals(String searchString);


}
