package com.example.Mapping.Repository;

import com.example.Mapping.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Query method using method naming conventions
    List<Student> findByName(String name);

    // Query method using method naming conventions with multiple parameters
    List<Student> findByAgeGreaterThanAndEmailContains(int age, String emailDomain);

    // Query method using @Query annotation
    @Query("SELECT s FROM Student s WHERE s.name = :name AND s.age = :age")
    List<Student> findStudentsByNameAndAge(@Param("name") String name, @Param("age") int age);

    // Query method using @Query annotation with native query
    @Query(value = "SELECT * FROM Student s WHERE s.email = :email", nativeQuery = true)
    Student findStudentByEmail(@Param("email") String email);
}
