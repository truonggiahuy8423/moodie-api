package com.example.moodie.entity.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseLecturerId {
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "lecturer_id")
    private Long lecturerId;
}
