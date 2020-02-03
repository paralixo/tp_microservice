package com.archi.tp.gradestudents.controllers;

import com.archi.tp.gradestudents.entities.GradeStudentsDTO;
import com.archi.tp.gradestudents.services.GradeStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeStudentsController {
    @Autowired
    GradeStudentsService gradeStudentsServiceService;

    @RequestMapping("/gradeStudents/{gradeId}")
    ResponseEntity<GradeStudentsDTO> getGradeStudents(@PathVariable() Long gradeId) {
        return new ResponseEntity<>(gradeStudentsServiceService.getGradeStudents(gradeId), HttpStatus.OK);
    }

    @RequestMapping("/gradeStudents")
    ResponseEntity<List<GradeStudentsDTO>> getGradesAndStudents() {
        return new ResponseEntity<>(gradeStudentsServiceService.getGradesAndStudents(), HttpStatus.OK);
    }
}
