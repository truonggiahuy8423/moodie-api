package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "BIGINT")
    private Long userId;

    @Column(name = "username", columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(10)")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "gender")
    private Boolean gender; // Female true - Male fale

    @Column(name = "date_of_birth", columnDefinition = "DATE DEFAULT CURRENT_TIMESTAMP")
    private LocalDate dob;

    @Column(name = "country_code", length = 2)
    private String countryCode;

    @Lob
    @Column(name = "avatar")
    private byte[] avatar;

    // Relation "One"
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<RoleUser> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<PermissionUser> permissions;

}

