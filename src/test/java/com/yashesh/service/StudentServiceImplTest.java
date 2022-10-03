package com.yashesh.service;

import com.yashesh.entity.Country;
import com.yashesh.entity.School;
import com.yashesh.entity.Student;
import com.yashesh.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    StudentRepository studentRepository;

    @Mock
    SchoolService schoolService;

    @Mock
    CountryService countryService;

    @Before
    public void setUp() throws Exception {
        // Initialize mocks created above
        MockitoAnnotations.initMocks(this);
        // Change behaviour of `resource`
    }

    @Test
    public void testSaveStudent() {

        Student student = new Student();
        School school=new School();
        school.setId(1);
        Country country = new Country();
        country.setId(2L);
        student.setLastName("Modi");
        student.setFirstName("Yashesh");
        student.setSchool(school);
        student.setCountry(country);
        student.setMarks1(10);
        student.setMarks2(20);
        student.setMarks3(30);

        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(student);
        Mockito.when(schoolService.getSchoolById(Mockito.any())).thenReturn(school);
        Mockito.when(countryService.getById(Mockito.anyLong())).thenReturn(country);
        Student save = studentService.saveStudent(student);

        Assertions.assertEquals(60, save.getTotalMarks());
        Assertions.assertEquals("Yashesh", save.getFirstName());
        Assertions.assertEquals(1,save.getSchool().getId());
        Assertions.assertEquals(2,save.getCountry().getId());

    }

}
