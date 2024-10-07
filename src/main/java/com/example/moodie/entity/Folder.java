package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "folder")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Folder {
    @Id
    @Column(name = "folder_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "folder")
    private List<Assignment> assignments;

    @JsonIgnore
    @OneToMany(mappedBy = "folder")
    private List<Link> links;

    @JsonIgnore
    @OneToMany(mappedBy = "folder")
    private List<Topic> topics;

    @JsonIgnore
    @OneToMany(mappedBy = "folder")
    private List<Folder> folders;

    @JsonIgnore
    @OneToMany(mappedBy = "folder")
    private List<FileFolder> files;

    //Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_folder_id", referencedColumnName = "folder_id")
    private Folder folder;

}
