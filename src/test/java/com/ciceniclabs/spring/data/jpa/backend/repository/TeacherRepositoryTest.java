package com.ciceniclabs.spring.data.jpa.backend.repository;

import com.ciceniclabs.spring.data.jpa.backend.entity.Course;
import com.ciceniclabs.spring.data.jpa.backend.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){

        Course courseJava = Course.builder()
                .title("Java Masterclass")
                .credit(9)
                .build();

        Course coursePHP = Course.builder()
                .title("PHP Masterclass")
                .credit(9)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Silas")
                .lastName("Amwoka")
//                .courses(List.of(coursePHP,courseJava))
                .build();

        teacherRepository.save(teacher);

    }
}