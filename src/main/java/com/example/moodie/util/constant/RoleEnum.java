package com.example.moodie.util.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    ADMIN("ADMIN"),
    USER("USER");



    private final String roleName;
}