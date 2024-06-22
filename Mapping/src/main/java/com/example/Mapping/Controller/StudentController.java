package com.example.Mapping.Controller;

import com.example.Mapping.Model.Student;
import com.example.Mapping.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    // Create a new student
    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    // Get all students
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Get paged and sorted students
    @GetMapping("/paged")
    public ResponseEntity<Page<Student>> getStudentsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        Page<Student> students = studentService.getStudents(page, size, sortBy);
        return ResponseEntity.ok(students);
    }

    // Get sorted students
    @GetMapping("/sorted")
    public ResponseEntity<List<Student>> getStudentsSorted(
            @RequestParam(defaultValue = "name") String sortBy) {
        List<Student> students = studentService.getStudentsSortedBy(sortBy);
        return ResponseEntity.ok(students);
    }
}
