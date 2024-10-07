package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "file")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class File {
    @Id
    @Column(name = "file_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "decoded", columnDefinition = "VARCHAR(50)")
    private String decoded;

    @Column(name = "file_name", columnDefinition = "VARCHAR(50)")
    private String fileName;

    @Column(name = "extension", columnDefinition = "VARCHAR(10)")
    private String extension;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "file")
    private List<FileFolder> folders;

    @JsonIgnore
    @OneToMany(mappedBy = "file")
    private List<FileSubmit> submits;

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


}
