package com.yashesh.service;

import com.yashesh.entity.School;
import com.yashesh.entity.Student;

import java.util.List;

public interface SchoolService {

    List<School> getAllSchool();
    School saveSchools(School school);
    School getSchoolById(Long id);
    School updateSchool(School school);
}
