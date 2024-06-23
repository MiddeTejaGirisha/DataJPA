package com.example.Mapping.Controller;

import com.example.Mapping.Model.Course;
import com.example.Mapping.Model.Student;
import com.example.Mapping.Repository.CourseRepository;
import com.example.Mapping.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@RestController
@RequestMapping("/Students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        //return studentService.createStudent(student);
        Set<Course> uniqueCourses=new HashSet<>();
        for (Course course : student.getCourses()) {
            Course existingCourse = courseRepository.findByName(course.getName());
            if(Objects.nonNull(existingCourse)){
                uniqueCourses.add(existingCourse);
            }
            else{uniqueCourses.add(course);}
        }
        student.setCourses(uniqueCourses);

        return studentService.createStudent(student);

    }



    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
