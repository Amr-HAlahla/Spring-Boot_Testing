package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Amr = new Student(
                    "Amr Halahla",
                    "amr@gmail.com",
                    LocalDate.of(2002, 5, 4)
            );
            Student Guest = new Student(
                    "Guest",
                    "guest__@gmail.com",
                    LocalDate.of(2002, 1, 1)
            );
            studentRepository.saveAll(
                    List.of(Amr, Guest)
            );
        };
    }
}
