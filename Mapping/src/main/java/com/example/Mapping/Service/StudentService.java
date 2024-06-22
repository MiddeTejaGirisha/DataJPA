package com.example.Mapping.Service;

import com.example.Mapping.Model.Student;
import com.example.Mapping.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentsByAgeGreaterThanAndEmailContains(int age, String emailDomain) {
        return studentRepository.findByAgeGreaterThanAndEmailContains(age, emailDomain);
    }

    public List<Student> getStudentsByNameAndAge(String name, int age) {
        return studentRepository.findStudentsByNameAndAge(name, age);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
