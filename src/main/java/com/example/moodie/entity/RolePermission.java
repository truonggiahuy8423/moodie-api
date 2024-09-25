package com.example.moodie.entity;

import com.example.moodie.entity.composite.RolePermissionId;
import com.example.moodie.entity.composite.RoleUserId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role_permission")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RolePermission {
    @EmbeddedId
    private RolePermissionId id;
    // Relation "One"

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id", insertable = false, updatable = false)
    private Permission permission;

    @JsonIgnore
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;
}
