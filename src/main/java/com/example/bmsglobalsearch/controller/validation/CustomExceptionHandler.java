package com.example.bmsglobalsearch.controller.validation;


import com.example.bmsglobalsearch.exception.DuplicateRecordException;
import com.example.bmsglobalsearch.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException err) {
        List<String> details = new ArrayList<>();
        details.add(err.getMessage());
        ErrorResponse error = new ErrorResponse("illegal argument", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(EntityNotFoundException err) {
        List<String> details = new ArrayList<>();
        details.add(err.getMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DuplicateRecordException.class)
    public final ResponseEntity<Object> handleDuplicateRecordException(DuplicateRecordException err) {
        List<String> details = new ArrayList<>();
        details.add(err.getMessage());
        ErrorResponse error = new ErrorResponse("Duplicate Record", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }


}
