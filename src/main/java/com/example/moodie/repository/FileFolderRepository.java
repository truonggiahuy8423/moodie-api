package com.example.moodie.repository;

import com.example.moodie.entity.FileFolder;
import com.example.moodie.entity.composite.FileFolderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileFolderRepository extends JpaRepository<FileFolder, FileFolderId> {
}
