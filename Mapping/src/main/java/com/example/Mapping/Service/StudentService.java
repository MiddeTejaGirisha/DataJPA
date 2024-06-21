package com.example.Mapping.Service;

import com.example.Mapping.Model.Course;
import com.example.Mapping.Model.Student;
import com.example.Mapping.Repository.CourseRepository;
import com.example.Mapping.Repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
