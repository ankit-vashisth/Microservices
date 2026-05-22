/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services.userservices.exceptionHandling;

import java.net.ConnectException;
import java.rmi.ServerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author CCS
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> arithmeticExceptionHandler(ArithmeticException ex) {
        System.out.println("111111111111");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Arithmetic Exception found.");
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> arrayIndexOutOfBoundExceptionHandler(ArrayIndexOutOfBoundsException ex) {
        System.out.println("22222222222222222");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Array index out of Bound Exception.");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex) {
        System.out.println("3333333333333333333");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Null pointer exception.");
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> connectionExceptionHandler(ConnectException ex) {
        System.out.println("4444444444444444444444");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("connection failure.");
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<String> resourceAccessExceptionHandler(ResourceAccessException ex) {
        System.out.println("555555555555555555555555");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order service unavailable" + ex.getMessage());
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<String> connectionExceptionHandler(ServerError ex) {
        System.out.println("6666666666666666666666666");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        System.out.println("777777777777777777777777777777");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}
