package com.mustafaakurt.school.converter;

import com.mustafaakurt.school.dto.request.SchoolRequest;
import com.mustafaakurt.school.dto.response.SchoolResponse;
import com.mustafaakurt.school.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School convertToSchool(SchoolRequest schoolRequest) {
        School school = new School();
        school.setSchoolName(schoolRequest.getSchoolName());
        return school;
    }

    public static SchoolResponse convertToSchoolResponse(School school) {
        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setSchoolName(school.getSchoolName());
        schoolResponse.setCreatedDate(school.getCreatedDate().toString());
        return schoolResponse;
    }
}
