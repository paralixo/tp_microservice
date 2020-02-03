package com.archi.tp.gradestudents.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Long id;
    private Long grade;
    private String firstName;
    private String lastName;
    private String birthDate;
}
