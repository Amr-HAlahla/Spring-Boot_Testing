package com.example.demo.student;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table()
public class Student {
    @Id
    @TableGenerator(name="TABLE_GEN",table="T_GENERATOR",pkColumnName="GEN_KEY",pkColumnValue="TEST",valueColumnName="GEN_VALUE",initialValue=1,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
    public Long studentId;

    //    @studentId
//    @SequenceGenerator(name = "my_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq")
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "RTDS_ADSINPUT_SEQ",
//            initialValue = 1, allocationSize = 1)
//    @GeneratedValue(
//            strategy = GenerationType.AUTO,
//            generator = "student_sequence"
//    )
    private String name;
    private String email;
    @Transient
    private Integer age;
    private LocalDate dob;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.studentId = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ",\n name='" + name + '\'' +
                ",\n email='" + email + '\'' +
                ",\n age=" + age +
                ",\n dob=" + dob +
                '}';
    }
}
