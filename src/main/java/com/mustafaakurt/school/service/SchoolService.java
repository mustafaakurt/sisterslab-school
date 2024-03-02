package com.mustafaakurt.school.service;

import com.mustafaakurt.school.converter.SchoolConverter;
import com.mustafaakurt.school.dto.request.SchoolRequest;
import com.mustafaakurt.school.dto.response.SchoolCreateResponse;
import com.mustafaakurt.school.exception.SchoolAlreadyExistException;
import com.mustafaakurt.school.model.School;
import com.mustafaakurt.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolCreateResponse createSchool(SchoolRequest request) {
        Optional<School> school = schoolRepository.findBySchoolName(request.getSchoolName());
        if (school.isPresent()) {
            throw new SchoolAlreadyExistException("Schoolname already exists with name + " + request.getSchoolName());
        }
        return SchoolConverter.convertToSchoolCreateResponse(schoolRepository.save(SchoolConverter.convertToSchool(request)));

    }
}
