package com.example.moodie.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @Column(name = "student_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @OneToOne(mappedBy = "student")
    private User user;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Submit> submits;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<CourseStudent> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;
}
