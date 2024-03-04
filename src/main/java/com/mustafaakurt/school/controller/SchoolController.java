package com.mustafaakurt.school.controller;

import com.mustafaakurt.school.dto.request.SchoolRequest;
import com.mustafaakurt.school.dto.response.SchoolResponse;
import com.mustafaakurt.school.exception.SchoolAlreadyExistException;
import com.mustafaakurt.school.exception.SchoolNotFoundException;
import com.mustafaakurt.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public SchoolResponse createSchool(@RequestBody SchoolRequest request) {
        return schoolService.createSchool(request);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }

    @GetMapping("/{id}")
    public SchoolResponse getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    @PutMapping("/{id}")
    public SchoolResponse updateSchool(@PathVariable Long id, @RequestBody SchoolRequest request) {
        return schoolService.updateSchool(id, request);
    }


    // Bu burada olmamalı geçici süreliğine burada
    @ExceptionHandler(SchoolAlreadyExistException.class)
    public ResponseEntity<String> handleSchoolAlreadyExistException(SchoolAlreadyExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(SchoolNotFoundException.class)
    public ResponseEntity<String> handleSchoolNotFoundException(SchoolNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
