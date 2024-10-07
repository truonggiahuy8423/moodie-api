package com.example.moodie.repository;

import com.example.moodie.entity.CourseStudent;
import com.example.moodie.entity.composite.CourseStudentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, CourseStudentId> {
}
