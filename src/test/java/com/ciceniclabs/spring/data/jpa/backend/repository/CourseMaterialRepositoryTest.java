package com.ciceniclabs.spring.data.jpa.backend.repository;

import com.ciceniclabs.spring.data.jpa.backend.entity.Course;
import com.ciceniclabs.spring.data.jpa.backend.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("Data Structure and Algorithms")
                .credit(12)
                .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.ciceniclabs.com")
                        .course(course)
                        .build();


        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial>  getCourseMaterial =
                repository.findAll();

        System.out.println("getCourseMaterial = " + getCourseMaterial);
    }
}