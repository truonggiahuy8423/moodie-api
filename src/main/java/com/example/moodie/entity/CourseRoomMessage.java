package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_room_message")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseRoomMessage {
    @Id
    @Column(name = "course_room_message_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseRoomMessageId;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Lob
    @Column(name = "image")
    private byte[] image;

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;
}
