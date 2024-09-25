package com.example.moodie.repository;

import com.example.moodie.entity.Role;
import com.example.moodie.entity.RoleUser;
import com.example.moodie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepository  extends JpaRepository<RoleUser, Long> {
    boolean existsByUserAndRole(User user, Role role);
}
