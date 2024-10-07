package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "role")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role {
    @Id
    @Column(name = "role_id", columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name", columnDefinition = "VARCHAR(100)")
    private String roleName;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<RoleUser> users;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<RolePermission> permissions;

}
