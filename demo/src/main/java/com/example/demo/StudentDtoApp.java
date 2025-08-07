// Problem:Instead of returning entire entities, use a StudentDTO to expose only name and email fields in the API response.
// Goal:Understand DTO pattern and data mapping (manual or using ModelMapper).

package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/students")
public class StudentDtoApp {

    private final StudentRepository studentRepo;

    public StudentDtoApp(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentDtoApp.class, args);
    }

   
    @PostMapping
    public StudentDTO create(@RequestBody Student student) {
        return mapToDTO(studentRepo.save(student));
    }

 
    @GetMapping
    public List<StudentDTO> getAll() {
        return studentRepo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(student.getName(), student.getEmail());
    }
}


@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotNull
    private String department;

    public Student() {}

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
}


class StudentDTO {
    private String name;
    private String email;

    public StudentDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters only for read-only response
    public String getName() { return name; }
    public String getEmail() { return email; }
}


interface StudentRepository extends JpaRepository<Student, Long> {}
