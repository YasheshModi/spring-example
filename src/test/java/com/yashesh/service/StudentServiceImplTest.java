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

import java.util.Optional;

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

    @Mock
    StudentService service;

    @Before
    public void setUp() throws Exception {
        // Initialize mocks created above
        MockitoAnnotations.initMocks(this);
        // Change behaviour of `resource`
    }

    @Test
    public void testSaveStudent_when_student_null_then_return_null() {

        Student save = studentService.saveStudent(null);

        Assertions.assertTrue(save == null);

    }

    @Test(expected = RuntimeException.class)
    public void testSaveStudent_when_student_fNameNull_then_return_Exception() {

        Student save = studentService.saveStudent(new Student());

    }
    @Test
    public void testSaveStudent_then_return_student() {

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


    @Test
    public void testUpdateStudent_when_student_null_then_return_null(){
        Student update = studentService.updateStudent(16L,null);
        Assertions.assertTrue(update == null);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateStudent_when_student_fNameNull_then_return_exception(){
        Student student = new Student();
        student.setFirstName(null);
        Student update = studentService.updateStudent(16L,student);

    }

    @Test(expected = RuntimeException.class)
    public void testUpdateStudent_when_student_lNameNull_then_return_exception(){
        Student student = new Student();
        student.setFirstName("Aman");
        student.setLastName(null);
        Student update = studentService.updateStudent(16L,student);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateStudent_when_student_emailNull_then_return() {
        Student student = new Student();
        student.setFirstName("Aman");
        student.setLastName("Raj");
        student.setEmail(null);
        Student update = studentService.updateStudent(16L,student);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateStudent_when_student_schoolNull_then_return_exception() {
        Student student = new Student();
        student.setFirstName("Aman");
        student.setLastName("Raj");
        student.setEmail("aman@gmail.com");
        student.setSchool(null);
        Student update = studentService.updateStudent(16L,student);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateStudent_when_student_countryNull_then_return_exception() {
        Student student = new Student();
        student.setFirstName("Aman");
        student.setLastName("Raj");
        student.setEmail("aman@gmail.com");
        School school = new School();
        school.setId(1);
        student.setSchool(school);
        student.setCountry(null);
        Student update = studentService.updateStudent(16L,student);
    }

    @Test
    public void testUpdateStudent_then_return_student() {
        Student student = new Student();
        School school=new School();
        school.setId(1);
        Country country = new Country();
        country.setId(2L);

        student.setId(16L);
        student.setFirstName("Karan");
        student.setLastName("Mistry");
        student.setEmail("raj@gmail.com");
        student.setSchool(school);
        student.setCountry(country);

        Mockito.when(studentRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(student));
        Mockito.when(studentRepository.save(Mockito.any())).thenReturn(student);
        Mockito.when(schoolService.getSchoolById(Mockito.any())).thenReturn(school);
        Mockito.when(countryService.getById(Mockito.anyLong())).thenReturn(country);
        Student update=studentService.updateStudent(16L,student);

        Assertions.assertEquals(16,update.getId());
        Assertions.assertEquals("Raj",update.getFirstName());
        Assertions.assertEquals("Mistry",update.getLastName());
        Assertions.assertEquals("raj@gmail.com",update.getEmail());
        Assertions.assertEquals(1,update.getSchool().getId());
        Assertions.assertEquals(2L,update.getCountry().getId());

    }
}
