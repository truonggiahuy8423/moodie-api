package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "course_schedule_status")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseScheduleStatus {
    @Id
    @Column(name = "course_schedule_status_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classScheduleStatusId;

    @Column(name = "status", columnDefinition = "VARCHAR(50)")
    private String status;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "courseScheduleStatus")
    private List<CourseSchedule> courseSchedules;
}
