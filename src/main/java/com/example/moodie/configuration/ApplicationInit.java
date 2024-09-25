package com.example.moodie.configuration;

import com.example.moodie.entity.Permission;
import com.example.moodie.entity.Role;
import com.example.moodie.repository.PermissionRepository;
import com.example.moodie.repository.RoleRepository;
import com.example.moodie.repository.UserRepository;
import com.example.moodie.service.UserService;
import com.example.moodie.util.constant.PermissionEnum;
import com.example.moodie.util.constant.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationInit {
    @Bean
    @Autowired
    ApplicationRunner applicationRunner(UserService userService, RoleRepository roleRepository, PermissionRepository permissionRepository) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                // Add roles if they don't exist
                for (RoleEnum roleEnum : RoleEnum.values()) {
                    if (!roleRepository.existsByRoleName(roleEnum.getRoleName())) {
                        roleRepository.save(Role.builder().roleName(roleEnum.getRoleName()).build());
                    }
                }

                // Add permissions if they don't exist
                for (PermissionEnum permissionEnum : PermissionEnum.values()) {
                    if (!permissionRepository.existsByPermissionName(permissionEnum.getPermissionName())) {
                        permissionRepository.save(Permission.builder().permissionName(permissionEnum.getPermissionName()).build());
                    }
                }

                userService.initAdmin();
            }
        };
    }

}
