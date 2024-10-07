package com.example.moodie.entity;

import com.example.moodie.entity.composite.CourseLecturerId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "course_lecturer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseLecturer {
    @EmbeddedId
    private CourseLecturerId id;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    // Relation "One"

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @JsonIgnore
    @ManyToOne
    @MapsId("lecturerId")
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;


}
