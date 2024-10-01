package com.example.moodie.exception.handler;

import com.example.moodie.dto.response.AppResponse;
import com.example.moodie.dto.response.ErrorResponse;
import com.example.moodie.exception.AppRuntimeException;
import com.example.moodie.util.constant.ExceptionType;
import com.example.moodie.util.ApiMessage;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<AppResponse<Object>> handlingRuntimeException(Exception exception) {
        ExceptionType errorType = ExceptionType.UNCATEGORIZED_EXCEPTION;
        return new ResponseEntity<AppResponse<Object>>(new AppResponse<>(HttpStatus.BAD_REQUEST.value(), ApiMessage.FAILED,
                new ErrorResponse(errorType.getErrorCode(), errorType.getErrorMessage() + "-" + exception.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<AppResponse<Object>> handlingRuntimeException(MethodArgumentNotValidException exception) {
        String enumKey = exception.getFieldError().getDefaultMessage();
        ExceptionType e = null;

        try {
            e = ExceptionType.valueOf(enumKey);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        assert e != null;
        return new ResponseEntity<AppResponse<Object>>(new AppResponse<>(HttpStatus.BAD_REQUEST.value(), ApiMessage.FAILED,
                new ErrorResponse(e.getErrorCode(), e.getErrorMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AppRuntimeException.class)
    ResponseEntity<AppResponse<Object>> handlingValidationException(AppRuntimeException exception) {

        System.out.println(exception.getMessage());

        return new ResponseEntity<AppResponse<Object>>(new AppResponse<>(exception.getHttpStatus().value(), ApiMessage.FAILED,
                new ErrorResponse(exception.getErrorCode(), exception.getErrorMessage())), exception.getHttpStatus());
    }

    // Handler cho EntityNotFoundException (khi không tìm thấy entity)
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<AppResponse<Object>> handleEntityNotFoundException(EntityNotFoundException exception) {
        ExceptionType errorType = ExceptionType.ENTITY_NOT_FOUND;
        return new ResponseEntity<>(new AppResponse<>(HttpStatus.NOT_FOUND.value(), ApiMessage.FAILED,
                new ErrorResponse(errorType.getErrorCode(), exception.getMessage())), HttpStatus.NOT_FOUND);
    }

    // Handler cho DataIntegrityViolationException (vi phạm toàn vẹn dữ liệu)
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<AppResponse<Object>> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ExceptionType errorType = ExceptionType.DATA_INTEGRITY_VIOLATION;
        return new ResponseEntity<>(new AppResponse<>(HttpStatus.CONFLICT.value(), ApiMessage.FAILED,
                new ErrorResponse(errorType.getErrorCode(), exception.getMessage())), HttpStatus.CONFLICT);
    }

    // Handler cho ConstraintViolationException (vi phạm ràng buộc trong JPA)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<AppResponse<Object>> handleConstraintViolationException(ConstraintViolationException exception) {
        ExceptionType errorType = ExceptionType.CONSTRAINT_VIOLATION;
        return new ResponseEntity<>(new AppResponse<>(HttpStatus.BAD_REQUEST.value(), ApiMessage.FAILED,
                new ErrorResponse(errorType.getErrorCode(), exception.getMessage())), HttpStatus.BAD_REQUEST);
    }

    // Handler cho ObjectOptimisticLockingFailureException (xung đột do xử lý locking optimistic)
    @ExceptionHandler(value = ObjectOptimisticLockingFailureException.class)
    public ResponseEntity<AppResponse<Object>> handleOptimisticLockingFailureException(ObjectOptimisticLockingFailureException exception) {
        ExceptionType errorType = ExceptionType.OPTIMISTIC_LOCKING_FAILURE;
        return new ResponseEntity<>(new AppResponse<>(HttpStatus.CONFLICT.value(), ApiMessage.FAILED,
                new ErrorResponse(errorType.getErrorCode(), exception.getMessage())), HttpStatus.CONFLICT);
    }
}
