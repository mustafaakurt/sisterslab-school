package com.mustafaakurt.school.controller;

import com.mustafaakurt.school.dto.request.SchoolRequest;
import com.mustafaakurt.school.dto.response.SchoolCreateResponse;
import com.mustafaakurt.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public SchoolCreateResponse createSchool(@RequestBody SchoolRequest request) {
        return schoolService.createSchool(request);
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }
}
