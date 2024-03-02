package com.mustafaakurt.school.exception;

public class SchoolAlreadyExistException extends RuntimeException {
    public SchoolAlreadyExistException(String message) {
        super(message);
    }
}
