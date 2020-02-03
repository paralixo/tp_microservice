package com.archi.tp.studentcore.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long grade;
    private String firstName;
    private String lastName;
    private String birthDate;
}
