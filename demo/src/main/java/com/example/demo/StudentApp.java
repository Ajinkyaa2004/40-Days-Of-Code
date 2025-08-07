// Problem:Add a method in the StudentRepository to find students by department using JPQL and @Query.
// Goal:Learn custom query building with @Query and @Param.

package com.example.demo;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/students")
public class StudentApp {

    private final StudentRepository studentRepository;

    public StudentApp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class, args);
    }

   
    @Bean
    CommandLineRunner run(StudentRepository repo) {
        return args -> {
            repo.save(new Student("Ajinkya", "CSE"));
            repo.save(new Student("Rahul", "IT"));
            repo.save(new Student("Sneha", "CSE"));
            repo.save(new Student("Meena", "ECE"));
        };
    }

  
    @GetMapping("/department")
    public List<Student> getByDepartment(@RequestParam String dept) {
        return studentRepository.findByDepartment(dept);
    }
}


@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    public Student() {}

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}

interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.department = :department")
    List<Student> findByDepartment(@Param("department") String department);
}
