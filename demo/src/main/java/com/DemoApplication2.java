// Problem:Build a GET API /students that supports pagination (page, size) and sorting (sortBy) for the Student entity.
// Goal:Use Pageable, Page<T>, and @RequestParam effectively.

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

// --- Entity ---
@Entity
class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int age;

	public Student() {}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
}

// --- Repository ---
interface StudentRepository extends JpaRepository<Student, Long> {}

// --- Controller ---
@RestController
@RequestMapping("/students")
class StudentController {

	private final StudentRepository repository;

	public StudentController(StudentRepository repository) {
		this.repository = repository;

		// Adding sample data
		repository.saveAll(List.of(
			new Student("Ajinkya", 21),
			new Student("Rahul", 22),
			new Student("Sneha", 20),
			new Student("Pooja", 23),
			new Student("Kiran", 24),
			new Student("Vikas", 25),
			new Student("Anjali", 21),
			new Student("Dev", 22)
		));
	}

	@GetMapping
	public Page<Student> getAllStudents(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String direction
	) {
		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return repository.findAll(pageable);
	}
}
