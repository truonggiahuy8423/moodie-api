package com.example.moodie.entity.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AttendanceId {
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_schedule_id")
    private Long courseScheduleId;
}
