package com.example.moodie.repository;

import com.example.moodie.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository  extends JpaRepository<RolePermission, Long> {
}
