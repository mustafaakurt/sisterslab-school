package com.mustafaakurt.school.repository;

import com.mustafaakurt.school.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface SchoolRepository extends JpaRepository<School, Long> {
    Optional<School> findBySchoolName(String schoolName);

    List<School> findAllBySchoolName(String schoolName);
}
