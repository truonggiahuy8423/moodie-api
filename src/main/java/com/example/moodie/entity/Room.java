package com.example.moodie.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "room")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Room {
    @Id
    @Column(name = "room_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(name = "room_name", columnDefinition = "VARCHAR(4)")
    private String roomName;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "room")
    private List<CourseSchedule> courseSchedules;

}
