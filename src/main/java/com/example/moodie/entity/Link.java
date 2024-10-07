package com.example.moodie.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "link")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Link {
    @Id
    @Column(name = "link_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "link", columnDefinition = "TEXT")
    private String link;

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
