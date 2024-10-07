package com.example.moodie.repository;

import com.example.moodie.entity.FileSubmit;
import com.example.moodie.entity.composite.FileSubmitId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileSubmitRepository extends JpaRepository<FileSubmit, FileSubmitId> {
}
