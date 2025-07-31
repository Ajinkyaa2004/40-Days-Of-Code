// CRUD API for Student Entity
// Problem: Build a REST API to perform Create, Read, Update, and Delete (CRUD) operations on a Student 
// entity with fields: id, name, email, and department.
// Goal: Use Spring Data JPA with JpaRepository, and map endpoints using @RestController.

package com.example.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
}

@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String department;


    public Student() {}
    public Student(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}


@Repository
interface StudentRepository extends JpaRepository<Student, Long> {
}


@RestController
@RequestMapping("/students")
class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }


    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setDepartment(updatedStudent.getDepartment());
        return repository.save(student);
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }
}
