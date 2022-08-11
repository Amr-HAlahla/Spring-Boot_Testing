package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //select email from student where email=?.
//    @Query("select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

//    Optional<Student> findStudentByStudentId(Long studentId);
}
