package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "submit")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Submit {
    @Id
    @Column(name = "submit_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submitId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "submit")
    private List<FileSubmit> files;

    //Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignment_id")
    private Assignment assignment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

}
