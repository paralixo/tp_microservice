package com.archi.tp.studentcore.controllers;

import com.archi.tp.studentcore.entities.Student;
import com.archi.tp.studentcore.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    ResponseEntity<Student> getAllStudents() {
        return new ResponseEntity(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return new ResponseEntity(studentRepository.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity(studentRepository.save(student), HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    ResponseEntity<Student> deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity(studentRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    ResponseEntity<Student> editStudentById(@RequestBody Student newStudent, @PathVariable Long id) {
        return new ResponseEntity(
            studentRepository.findById(id)
                .map(student -> {
                    String firstName = newStudent.getFirstName();
                    String lastName = newStudent.getLastName();
                    String birthDate = newStudent.getBirthDate();
                    Long grade = newStudent.getGrade();

                    if(firstName != null) {
                        student.setFirstName(firstName);
                    }
                    if(lastName != null) {
                        student.setLastName(lastName);
                    }
                    if(birthDate != null) {
                        student.setBirthDate(birthDate);
                    }
                    if(grade != null) {
                        student.setGrade(grade);
                    }

                    newStudent.setId(id);
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                }),
            HttpStatus.OK);
    }
}
