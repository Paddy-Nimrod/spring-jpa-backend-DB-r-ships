package com.ciceniclabs.spring.data.jpa.backend.repository;

import com.ciceniclabs.spring.data.jpa.backend.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
