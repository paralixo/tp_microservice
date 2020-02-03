package com.archi.tp.gradecore.controllers;

import com.archi.tp.gradecore.entities.Grade;
import com.archi.tp.gradecore.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class GradeController {
    @Autowired
    GradeRepository gradeRepository;

    @GetMapping("/grades")
    ResponseEntity<Grade> getAllStudents() {
        return new ResponseEntity(gradeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/grades/{id}")
    ResponseEntity<Grade> getStudentById(@PathVariable Long id) {
        return new ResponseEntity(gradeRepository.getGradeById(id), HttpStatus.OK);
    }

    @PostMapping("/grades")
    ResponseEntity<Grade> addStudent(@RequestBody Grade grade) {
        return new ResponseEntity(gradeRepository.save(grade), HttpStatus.OK);
    }

    @DeleteMapping("/grades/{id}")
    ResponseEntity<Grade> deleteStudentById(@PathVariable Long id) {
        gradeRepository.deleteById(id);
        return new ResponseEntity(gradeRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/grades/{id}")
    ResponseEntity<Grade> editStudentById(@RequestBody Grade newGrade, @PathVariable Long id) {
        return new ResponseEntity(
            gradeRepository.findById(id)
                .map(grade -> {
                    String title = newGrade.getTitle();
                    String headTeacher = newGrade.getHeadTeacher();
                    Integer year = newGrade.getYear();

                    if(title != null) {
                        grade.setTitle(title);
                    }
                    if(headTeacher != null) {
                        grade.setHeadTeacher(headTeacher);
                    }
                    if(year != null) {
                        grade.setYear(year);
                    }

                    newGrade.setId(id);
                    return gradeRepository.save(grade);
                })
                .orElseGet(() -> {
                    newGrade.setId(id);
                    return gradeRepository.save(newGrade);
                }),
            HttpStatus.OK);
    }
}
