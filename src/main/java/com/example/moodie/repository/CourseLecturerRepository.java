package com.example.moodie.repository;

import com.example.moodie.entity.CourseLecturer;
import com.example.moodie.entity.composite.CourseLecturerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseLecturerRepository extends JpaRepository<CourseLecturer, CourseLecturerId> {
}
