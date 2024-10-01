package com.example.moodie.util.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionType {
    UNCATEGORIZED_EXCEPTION(99999, "Unknown error", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(10007, "Email registered", HttpStatus.BAD_REQUEST),
    PHONE_EXISTED(10008, "Phone registered", HttpStatus.BAD_REQUEST),
    EMAIL_AND_PHONE_EXISTED(10009, "Email and phone registered", HttpStatus.BAD_REQUEST),
    EMAIL_AND_PHONE_EMPTY(10009, "Email and phone empty", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_ERROR(10002, "Authentication failed", HttpStatus.UNAUTHORIZED),
    AUTHORIZATION_ERROR(10003, "Authorization failed", HttpStatus.UNAUTHORIZED),
    RESOURCE_NOT_FOUND(10004, "Resource not found", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(10005, "Internal server error", HttpStatus.BAD_REQUEST),
    MISSING_REGISTER_PARAMETERS(10006, "Missing register parameters", HttpStatus.BAD_REQUEST),
    ENTITY_NOT_FOUND(10010, "Entity not found.", HttpStatus.BAD_REQUEST),
    DATA_INTEGRITY_VIOLATION(10011, "Data integrity violation.", HttpStatus.BAD_REQUEST),
    CONSTRAINT_VIOLATION(10012, "Constraint violation.", HttpStatus.BAD_REQUEST),
    OPTIMISTIC_LOCKING_FAILURE(10013, "Optimistic locking failure.", HttpStatus.BAD_REQUEST),
    LOGIN_FAILED(10014, "Incorrect email/phone number or password", HttpStatus.BAD_REQUEST),
    TOKEN_SIGNING_FAILED(10015, "Token generation failed", HttpStatus.BAD_REQUEST),
    EMAIL_INVALID(10016, "Email must contains 1-50 characters", HttpStatus.BAD_REQUEST),
    PHONE_INVALID(10017, "Phone number contains 10 characters", HttpStatus.BAD_REQUEST);

    private final Integer errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;
}
