// Problem:Secure your Student CRUD APIs using Basic Authentication. Create in-memory users with different roles (e.g., ADMIN, USER).
// Goal:Implement Spring Security and restrict API access based on roles.

package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/students")
@EnableMethodSecurity
public class StudentSecureApp {

    private final StudentRepository studentRepo;

    public StudentSecureApp(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentSecureApp.class, args);
    }


    @GetMapping
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student updated) {
        return studentRepo.findById(id).map(s -> {
            s.setName(updated.getName());
            s.setEmail(updated.getEmail());
            s.setDepartment(updated.getDepartment());
            return studentRepo.save(s);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentRepo.deleteById(id);
    }

 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/students").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/students/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic()
            .and()
            .build();
    }

  
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
}


interface StudentRepository extends JpaRepository<Student, Long> {}
