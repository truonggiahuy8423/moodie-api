package com.example.moodie.entity;

import com.example.moodie.entity.composite.RoleUserId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleUser {
    @EmbeddedId
    private RoleUserId id;
    // Relation "One"

    // Relation "Many"
    @JsonIgnore
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
}
