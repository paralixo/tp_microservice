package com.archi.tp.gradecore.repositories;

import com.archi.tp.gradecore.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> getGradeById(Long id);
}