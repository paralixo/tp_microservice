package com.archi.tp.api.controllers;

import com.archi.tp.api.entities.Grade;
import com.archi.tp.api.entities.Student;
import com.archi.tp.api.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    ApiService apiService;
    // marche pas
    @GetMapping("/gradeStudents/{id}")
    ResponseEntity<Object> getGradeStudents(@PathVariable Long id) {
        return new ResponseEntity<>(apiService.getGradeStudents(id), HttpStatus.OK);
    }

    @GetMapping("/gradeStudents")
    ResponseEntity<Object> getAllGradeStudents() {
        return new ResponseEntity<>(apiService.getGradesAndStudents(), HttpStatus.OK);
    }

    @GetMapping("/students")
    ResponseEntity<Object> getAllStudents() {
        return new ResponseEntity<>(apiService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    ResponseEntity<Object> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(apiService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    ResponseEntity<List<Student>> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<List<Student>>(apiService.saveStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    ResponseEntity<List<Student>> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<List<Student>>(apiService.deleteStudent(id), HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    ResponseEntity<List<Student>> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        return new ResponseEntity<List<Student>>(apiService.updateStudent(id, student), HttpStatus.OK);
    }

    @GetMapping("/grades")
    ResponseEntity<Object> getAllGrades() {
        return new ResponseEntity<>(apiService.getGrades(), HttpStatus.OK);
    }

    @GetMapping("/grades/{id}")
    ResponseEntity<Object> getGradeById(@PathVariable Long id) {
        return new ResponseEntity<>(apiService.getGradeById(id), HttpStatus.OK);
    }

    @PostMapping("/grades")
    ResponseEntity<List<Grade>> saveGrade(@RequestBody Grade grade) {
        return new ResponseEntity<List<Grade>>(apiService.saveGrade(grade), HttpStatus.OK);
    }

    @DeleteMapping("/grades/{id}")
    ResponseEntity<List<Grade>> deleteGrade(@PathVariable Long id) {
        return new ResponseEntity<List<Grade>>(apiService.deleteGrade(id), HttpStatus.OK);
    }

    @PutMapping("/grades/{id}")
    ResponseEntity<List<Grade>> updateGrade(@RequestBody Grade grade, @PathVariable Long id) {
        return new ResponseEntity<List<Grade>>(apiService.updateGrade(id, grade), HttpStatus.OK);
    }

}

