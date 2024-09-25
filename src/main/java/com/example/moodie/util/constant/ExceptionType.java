package com.example.moodie.util.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionType {
    UNCATEGORIZED_EXCEPTION(99999, "Unknown error"),
    EMAIL_EXISTED(10007, "Email registered"),
    PHONE_EXISTED(10008, "Phone registered"),
    EMAIL_AND_PHONE_EXISTED(10009, "Email and phone registered"),
    EMAIL_AND_PHONE_EMPTY(10009, "Email and phone empty"),
    AUTHENTICATION_ERROR(10002, "Authentication failed"),
    AUTHORIZATION_ERROR(10003, "Authorization failed"),
    RESOURCE_NOT_FOUND(10004, "Resource not found"),
    INTERNAL_SERVER_ERROR(10005, "Internal server error"),
    MISSING_REGISTER_PARAMETERS(10006, "Missing register parameters"),
    ENTITY_NOT_FOUND(10010, "Entity not found."),
    DATA_INTEGRITY_VIOLATION(10011, "Data integrity violation."),
    CONSTRAINT_VIOLATION(10012, "Constraint violation."),
    OPTIMISTIC_LOCKING_FAILURE(10013, "Optimistic locking failure."),
    LOGIN_FAILED(10014, "Incorrect email/phone number or password"),
    TOKEN_SIGNING_FAILED(10015, "Token generation failed"),
    EMAIL_INVALID(10016, "Email must contains 1-50 characters"),
    PHONE_INVALID(10017, "Phone number contains 10 characters");

    private final Integer errorCode;
    private final String errorMessage;
}
