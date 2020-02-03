package com.archi.tp.gradestudents.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeStudentsDTO {
    private Grade grade;
    private List<Student> students;
}
