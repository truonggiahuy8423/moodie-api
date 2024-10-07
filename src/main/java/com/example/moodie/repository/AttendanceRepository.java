package com.example.moodie.repository;

import com.example.moodie.entity.Attendance;
import com.example.moodie.entity.composite.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
}
