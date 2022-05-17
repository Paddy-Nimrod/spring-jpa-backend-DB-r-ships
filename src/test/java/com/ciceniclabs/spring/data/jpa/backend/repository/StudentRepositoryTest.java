package com.ciceniclabs.spring.data.jpa.backend.repository;

import com.ciceniclabs.spring.data.jpa.backend.entity.Guardian;
import com.ciceniclabs.spring.data.jpa.backend.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("nimrod@outlook.com")
                .firstName("Nimrod")
                .lastName("Programmer")
                //.guardianName("Mama")
                //.guardianEmail("mama@mamawatoto.com")
                //.guardianMobile("0708506842")
                .build();


        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("babawatoto")
                .email("babawatoto@email.com")
                .mobile("9999884884")
                .build();

        Student student = Student.builder()
                .firstName("Harold")
                .lastName("Cooper")
                .emailId("harold@protonmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> newStudentList =
                studentRepository.findByFirstName("nimrod");

        System.out.println("new students list = " + newStudentList);
    }


    @Test
    public void printAllStudents(){
        List<Student> studentList =
            studentRepository.findAll();

        System.out.println("student's List is" + studentList);
    }

    @Test
    public void printStudentByGuardian(){
        List<Student> studentList =
                studentRepository.findByGuardianName("babawatoto");

        System.out.println("studentList = " + studentList);
    }


    @Test
    public void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress("harold@protonmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("harold@protonmail.com");
        System.out.println("student = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("harold@protonmail.com");

        System.out.println("student = " + student);
    }


    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("harold@protonmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void modifyStudentDataUsingNativeQuery(){
        studentRepository.updateStudentNameByEmailId(
                "Harold Cooper",
                "harold@protonmail.com");
    }
}
















