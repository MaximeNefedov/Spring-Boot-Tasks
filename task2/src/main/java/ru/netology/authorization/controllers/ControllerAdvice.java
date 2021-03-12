package ru.netology.authorization.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorization.exceptions.InvalidCredentials;
import ru.netology.authorization.exceptions.InvalidPassword;
import ru.netology.authorization.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(InvalidPassword.class)
    public ResponseEntity<String> handleInvalidPassword(InvalidPassword e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
