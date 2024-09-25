package com.example.moodie.repository;

import com.example.moodie.entity.PermissionUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionUserRepository  extends JpaRepository<PermissionUser, Long> {
}
