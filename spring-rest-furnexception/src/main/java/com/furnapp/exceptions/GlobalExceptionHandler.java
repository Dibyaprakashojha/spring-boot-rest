package com.furnapp.exceptions;

import com.furnapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public GlobalExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc", "Method not allowed");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Method not supported");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,error,messages,status.value());
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc", "Media type not supported");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Invalid Media Type");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,error,messages,status.value());
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc", "Path Variable is missing");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Missing PathVariable");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,error,messages,status.value());
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    // if we don't give parameter while using @RequestParam, Request Param Missing
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc", "Request Param missing");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Invalid request parameter");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,error,messages,status.value());
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    // if we give String value in-place of int, TypeMisMatchException
    protected ResponseEntity<Object> handleTypeMismatch (TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc", "Invalid datatype");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Invalid data type");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,error,messages,status.value());
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(FurnitureNotFoundException.class)
    public ResponseEntity<Object> handleFurnNotFound(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Furniture Not Available");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"furniture not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,error,messages,HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Other Exception");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Other type of exception");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_ACCEPTABLE,error,messages,HttpStatus.NOT_ACCEPTABLE.value());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }

}
