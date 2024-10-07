package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "assignment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Assignment {
    @Id
    @Column(name = "assignment_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "assignment")
    private List<Submit> submits;

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
    private Lecturer lecturer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "folder_id", referencedColumnName = "folder_id")
    private Folder folder;
}
