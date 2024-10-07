package com.example.moodie.entity;

import com.example.moodie.entity.composite.AttendanceId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Attendance {
    @EmbeddedId
    private AttendanceId id;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "is_absent")
    private Boolean isAbsent;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    // Relation "One"

    // Relation "Many"
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("studentId")
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("courseScheduleId")
    @JoinColumn(name = "course_schedule_id", referencedColumnName = "course_schedule_id")
    private CourseSchedule courseSchedule;


}
