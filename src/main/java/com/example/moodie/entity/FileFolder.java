package com.example.moodie.entity;

import com.example.moodie.entity.composite.FileFolderId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_folder")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileFolder {
    @EmbeddedId
    private FileFolderId id;

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
    @MapsId("folderId")
    @JoinColumn(name = "folder_id", referencedColumnName = "folder_id")
    private Folder folder;

    @JsonIgnore
    @ManyToOne
    @MapsId("fileId")
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private File file;


}
