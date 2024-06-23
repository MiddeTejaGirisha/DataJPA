package com.example.Mapping.Repository;

import com.example.Mapping.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String name);
}
