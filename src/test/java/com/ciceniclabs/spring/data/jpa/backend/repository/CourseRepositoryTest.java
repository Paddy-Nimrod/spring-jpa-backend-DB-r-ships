package com.ciceniclabs.spring.data.jpa.backend.repository;

import com.ciceniclabs.spring.data.jpa.backend.entity.Course;
import com.ciceniclabs.spring.data.jpa.backend.entity.CourseMaterial;
import com.ciceniclabs.spring.data.jpa.backend.entity.Student;
import com.ciceniclabs.spring.data.jpa.backend.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printAllCourses(){
        List<Course> getAllCourses = 
                courseRepository.findAll();

        System.out.println("getAllCourses = " + getAllCourses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Allan")
                .lastName("Kuria")
                .build();


        Course course = Course.builder()
                .title("Java DS and Algorithms")
                .credit(20)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);

        Pageable secondPageWithTwoResults =
                PageRequest.of(1, 2);


        List <Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                                .getTotalElements();

        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages();

        System.out.println("courses = " + courses);

        System.out.println("totalElements = " + totalElements);

        System.out.println("totalPages = " + totalPages);

    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0, 2, Sort.by("title")
                );

        Pageable sortByCreditsDescending = 
                PageRequest.of(1, 2, Sort.by("credit").descending());


        Pageable sortByTitleAndCreditsDesc =
                PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("credit")));

        List <Course> courses =
                courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstTenRecords =
                PageRequest.of(0,2);

        List<Course> courses =
                courseRepository.findByTitleContaining("Master", firstTenRecords).getContent();

        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Tito")
                .lastName("Wa duka")
                .build();

        Student student = Student.builder()
                .firstName("Deno")
                .lastName("wa plot")
                .emailId("deno@yahoo.com")
                .build();

        Course course = Course.builder()
                .title("Docker and Kubernetes")
                .credit(8)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }




}