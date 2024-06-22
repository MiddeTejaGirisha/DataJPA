package com.example.Mapping.Controller;

import com.example.Mapping.Model.Student;
import com.example.Mapping.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
        List<Student> students = studentService.getStudentsByName(name);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/age/{age}/email/{emailDomain}")
    public ResponseEntity<List<Student>> getStudentsByAgeGreaterThanAndEmailContains(
            @PathVariable int age, @PathVariable String emailDomain) {
        List<Student> students = studentService.getStudentsByAgeGreaterThanAndEmailContains(age, emailDomain);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/name/{name}/age/{age}")
    public ResponseEntity<List<Student>> getStudentsByNameAndAge(
            @PathVariable String name, @PathVariable int age) {
        List<Student> students = studentService.getStudentsByNameAndAge(name, age);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        Student student = studentService.getStudentByEmail(email);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
