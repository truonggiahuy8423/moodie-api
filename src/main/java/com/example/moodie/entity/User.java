package com.example.moodie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "last_access", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime lastAccess;

    @Column(name = "gender")
    private Boolean gender; // Female true - Male fale

    @Column(name = "date_of_birth")
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

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<File> files;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<CourseRoomMessage> courseRoomMessages;

    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<PrivateMessage> sentPrivateMessage;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private List<PrivateMessage> receivedPrivateMessage;

    @OneToOne
    @JoinColumn(name = "administrator_id", referencedColumnName = "administrator_id")
    private Administrator administrator;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
    private Lecturer lecturer;




}

