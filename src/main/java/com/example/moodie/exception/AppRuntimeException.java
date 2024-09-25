package com.example.moodie.exception;

import com.example.moodie.util.constant.ExceptionType;
import lombok.Getter;

@Getter
public class AppRuntimeException extends RuntimeException {

    private final Integer errorCode;
    private final String errorMessage;


    // Constructor receiving ExceptionType enum
    public AppRuntimeException(ExceptionType exceptionType) {
        super(exceptionType.getErrorMessage());
        this.errorCode = exceptionType.getErrorCode();
        this.errorMessage = exceptionType.getErrorMessage();
    }

    public AppRuntimeException(ExceptionType exceptionType, String customMessage) {
        super(customMessage);
        this.errorCode = exceptionType.getErrorCode();
        this.errorMessage = customMessage;
    }

    // Override toString to provide better debugging
    @Override
    public String toString() {
        return "AppRuntimeException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + getMessage() + '\'' +
                '}';
    }
}