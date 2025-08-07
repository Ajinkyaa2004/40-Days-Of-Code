// Problem:Create an application where a Teacher entity has multiple Course entities. Implement endpoints to get all courses taught by a teacher.
// Goal:Understand @OneToMany, @ManyToOne, and proper entity mapping.

package com.example.demo;

import jakarta.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/teachers")
public class TeacherCourseApp {

    private final TeacherRepository teacherRepo;

    public TeacherCourseApp(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(TeacherCourseApp.class, args);
    }

   
    @Bean
    CommandLineRunner run(TeacherRepository teacherRepo) {
        return args -> {
            Teacher t1 = new Teacher("Ajinkya");
            Teacher t2 = new Teacher("Sneha");

            t1.addCourse(new Course("Java"));
            t1.addCourse(new Course("Spring Boot"));

            t2.addCourse(new Course("Python"));
            t2.addCourse(new Course("ML Basics"));

            teacherRepo.save(t1);
            teacherRepo.save(t2);
        };
    }

  
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

   
    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByTeacher(@PathVariable Long id) {
        return teacherRepo.findById(id)
                .map(Teacher::getCourses)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }
}

@Entity
class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses = new java.util.ArrayList<>();

    public Teacher() {}

    public Teacher(String name) {
        this.name = name;
    }

    public void addCourse(Course course) {
        course.setTeacher(this);
        this.courses.add(course);
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Course> getCourses() { return courses; }
}


@Entity
class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Course() {}

    public Course(String title) {
        this.title = title;
    }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    // Getters and setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Teacher getTeacher() { return teacher; }
}


interface TeacherRepository extends org.springframework.data.jpa.repository.JpaRepository<Teacher, Long> {}
