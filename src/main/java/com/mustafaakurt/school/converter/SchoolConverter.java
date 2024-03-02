package com.mustafaakurt.school.converter;

import com.mustafaakurt.school.dto.request.SchoolRequest;
import com.mustafaakurt.school.dto.response.SchoolCreateResponse;
import com.mustafaakurt.school.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School convertToSchool(SchoolRequest schoolRequest) {
        School school = new School();
        school.setSchoolName(schoolRequest.getSchoolName());
        return school;
    }

    public static SchoolCreateResponse convertToSchoolCreateResponse(School school) {
        SchoolCreateResponse schoolCreateResponse = new SchoolCreateResponse();
        schoolCreateResponse.setSchoolName(school.getSchoolName());
        schoolCreateResponse.setCreatedDate(school.getCreatedDate().toString());
        return schoolCreateResponse;
    }
}
