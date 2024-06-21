package com.example.Mapping.Repository;

import com.example.Mapping.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
