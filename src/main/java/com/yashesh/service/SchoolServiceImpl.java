package com.yashesh.service;

import com.yashesh.entity.School;
import com.yashesh.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        super();
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<School> getAllSchool() {
        return schoolRepository.findAll();
    }

    @Override
    public School saveSchools(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).get();
    }

    @Override
    public School updateSchool(School school) {
        return schoolRepository.save(school);
    }
}
