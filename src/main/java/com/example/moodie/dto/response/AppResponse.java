package com.example.moodie.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppResponse<T> {

    private Integer statusCode;
    private String message;
    private T data;
    private ErrorResponse error;

    public AppResponse(Integer statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public AppResponse(Integer statusCode, String message, ErrorResponse error) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
    }
}