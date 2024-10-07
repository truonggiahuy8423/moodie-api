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
public class FileSubmitId {
    @Column(name = "submit_id")
    private Long submitId;

    @Column(name = "file_id")
    private Long fileId;
}
