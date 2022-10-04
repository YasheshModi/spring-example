package com.yashesh.service;

import com.yashesh.entity.Country;
import com.yashesh.entity.School;
import com.yashesh.entity.Student;
import com.yashesh.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    private  SchoolService schoolService;
    @Autowired
    private CountryService countryService;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {

        if (student == null) {
            return null;
        }

        if (student.getFirstName() == null) {
            throw new RuntimeException("Firstname missing.");
        }

        if (student.getLastName() == null) {
            throw new RuntimeException("Lastname missing.");
        }

        Student st = new Student();
        st.setId(student.getId());
        st.setFirstName(student.getFirstName());
        st.setLastName(student.getLastName());
        st.setEmail(student.getEmail());
        School school = schoolService.getSchoolById(student.getSchool().getId());
        st.setSchool(school);
        Country country = countryService.getById(student.getCountry().getId());
        st.setCountry(country);
        st.setMarks1(student.getMarks1());
        st.setMarks2(student.getMarks2());
        st.setMarks3(student.getMarks3());
        Student save = studentRepository.save(st);

        calculateMarks(student, save);

        return save;
    }

    private void calculateMarks(Student student, Student save) {
        save.setTotalMarks(student.getMarks1() + student.getMarks2() + student.getMarks3());
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Long id,Student student) {

/*        if(student == null) {
            return null;
        }*/
        if(student.getFirstName() == null) {
            throw new RuntimeException("First name missing.");
        }
        if(student.getLastName() == null) {
            throw new RuntimeException("Last name missing.");
        }
        if(student.getEmail() == null) {
            throw new RuntimeException("Email missing.");
        }
        if(student.getSchool() == null) {
            throw new RuntimeException("School missing.");
        }
        if(student.getCountry() == null) {
            throw new RuntimeException("Country missing.");
        }

        Student existingStudent = getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        School school = schoolService.getSchoolById(student.getSchool().getId());
        existingStudent.setSchool(school);
        Country country = countryService.getById(student.getCountry().getId());
        existingStudent.setCountry(country);
        Student update = studentRepository.save(existingStudent);
        return update;
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getByFirstName(String firstName) {
        List<Student> byFirstName = studentRepository.findByFirstName(firstName);
        return byFirstName;
    }

    @Override
    public List<Student> getByLastName(String lastName) {
        List<Student> byLastName = studentRepository.findByLastName(lastName);
        return byLastName;
    }

    @Override
    public List<Student> getByEmail(String email) {
        List<Student> byEmail = studentRepository.findByEmail(email);
        return byEmail;
    }

    @Override
    public List<Student> getByCountryId(Long countryId) {
        List<Student> byCountry = studentRepository.findByCountryId(countryId);
        return byCountry;
    }

    @Override
    public List<Student> getBySchoolId(Long schoolId) {
        List<Student> bySchool = studentRepository.findBySchoolId(schoolId);
        return bySchool;
    }
     /*  @Override
    public Student getStudentByFirstNameOrLastName(String first_name,String last_name) {
        return studentRepository.findByFirstNameOrLastName(first_name,last_name);
    }*/
}