package com.example.moodie.repository;

import com.example.moodie.entity.Permission;
import com.example.moodie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository  extends JpaRepository<Permission, Long> {
    boolean existsByPermissionName(String permissionName);
}
