package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "course_schedule")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseSchedule {
    @Id
    @Column(name = "course_schedule_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classScheduleId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "start_time")
    @CreationTimestamp
    private LocalDateTime startTime;

    @Column(name = "end_time")
    @CreationTimestamp
    private LocalDateTime endTime;

    //Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "courseSchedule")
    private List<Attendance> attendances;

    //Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_schedule_status_id", referencedColumnName = "course_schedule_status_id")
    private CourseScheduleStatus courseScheduleStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

}
