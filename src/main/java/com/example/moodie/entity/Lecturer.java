package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "lecturer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Lecturer {
    @Id
    @Column(name = "lecturer_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturerId;

    @OneToOne(mappedBy = "lecturer")
    private User user;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "lecturer")
    private List<Assignment> assignments;

    @JsonIgnore
    @OneToMany(mappedBy = "lecturer")
    private List<Link> links;

    @JsonIgnore
    @OneToMany(mappedBy = "lecturer")
    private List<Topic> topics;

    @JsonIgnore
    @OneToMany(mappedBy = "lecturer")
    private List<CourseLecturer> courses;
}
