package com.mustafaakurt.school.service;

import com.mustafaakurt.school.converter.SchoolConverter;
import com.mustafaakurt.school.dto.request.SchoolRequest;
import com.mustafaakurt.school.dto.response.SchoolResponse;
import com.mustafaakurt.school.exception.SchoolAlreadyExistException;
import com.mustafaakurt.school.exception.SchoolNotFoundException;
import com.mustafaakurt.school.model.School;
import com.mustafaakurt.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolResponse createSchool(SchoolRequest request) {
        Optional<School> school = schoolRepository.findBySchoolName(request.getSchoolName());
        if (school.isPresent()) {
            throw new SchoolAlreadyExistException("Schoolname already exists with name + " + request.getSchoolName());
        }
        return SchoolConverter.convertToSchoolResponse(schoolRepository.save(SchoolConverter.convertToSchool(request)));

    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    public SchoolResponse getSchoolById(Long id) {
        return SchoolConverter.convertToSchoolResponse(findById(id));
    }

    private School findById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new SchoolNotFoundException("School not found with id " + id));
    }

    public SchoolResponse updateSchool(Long id, SchoolRequest request) {
        School school = findById(id);
        school.setSchoolName(request.getSchoolName());
        return SchoolConverter.convertToSchoolResponse(schoolRepository.save(school));
    }

    public List<School> getSchool(String schoolName) {
        if (schoolName != null) {
            return schoolRepository.findAllBySchoolName(schoolName);

        } else {
            return schoolRepository.findAll();
        }
    }
}
