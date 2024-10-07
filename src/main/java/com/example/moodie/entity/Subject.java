package com.example.moodie.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "subject")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Subject {
    @Id
    @Column(name = "subject_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column(name = "subject_name", columnDefinition = "VARCHAR(100)")
    private String subjectName;

    @Column(name = "subject_description", columnDefinition = "VARCHAR(100)")
    private String description;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<Course> courses;

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

}
