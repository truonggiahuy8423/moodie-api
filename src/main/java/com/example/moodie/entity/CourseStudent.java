package com.example.moodie.entity;

import com.example.moodie.entity.composite.CourseStudentId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseStudent {
    @EmbeddedId
    private CourseStudentId id;

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
    @MapsId("studentId")
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;


}
