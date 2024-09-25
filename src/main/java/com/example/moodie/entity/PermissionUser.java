package com.example.moodie.entity;

import com.example.moodie.entity.composite.PermissionUserId;
import com.example.moodie.entity.composite.RolePermissionId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permission_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PermissionUser {
    @EmbeddedId
    private PermissionUserId id;
    // Relation "One"

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id", insertable = false, updatable = false)
    private Permission permission;

    @JsonIgnore
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
