package com.example.moodie.entity;

import com.example.moodie.entity.composite.FileSubmitId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_submit")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileSubmit {
    @EmbeddedId
    private FileSubmitId id;

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
    @MapsId("submitId")
    @JoinColumn(name = "submit_id", referencedColumnName = "submit_id")
    private Submit submit;

    @JsonIgnore
    @ManyToOne
    @MapsId("fileId")
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private File file;


}