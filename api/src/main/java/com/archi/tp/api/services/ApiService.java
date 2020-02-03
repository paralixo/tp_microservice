package com.archi.tp.api.services;

import com.archi.tp.api.clients.IGradeClient;
import com.archi.tp.api.clients.IGradeStudentsClient;
import com.archi.tp.api.clients.IStudentClient;
import com.archi.tp.api.entities.Grade;
import com.archi.tp.api.entities.GradeStudentsDTO;
import com.archi.tp.api.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Data
public class ApiService {
    public IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8080/students");

    private IGradeClient iGradeClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeClient.class, "http://localhost:8081/grades");

    private IGradeStudentsClient iGradeStudentsClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeStudentsClient.class, "http://localhost:8082/gradeStudents");

    public List<GradeStudentsDTO> getGradesAndStudents() {
        return iGradeStudentsClient.getAllGradeStudents();
    }

    public GradeStudentsDTO getGradeStudents(Long id) {
        return iGradeStudentsClient.getGradeStudentsById(id);
    }

    public List<Student> getStudents() {
        return iStudentClient.getAll();
    }

    public List<Student> getStudentById(Long id) {
        return iStudentClient.getStudentById(id);
    }

    public List<Student> saveStudent(@RequestBody Student student) {
        return iStudentClient.saveStudent(student);
    }

    public List<Student> deleteStudent(Long id) {
        return iStudentClient.deleteStudentById(id);
    }

    public List<Student> updateStudent(Long id, Student student) {
        return iStudentClient.updateStudentById(id, student);
    }

    public List<Grade> getGrades() {
        return iGradeClient.getAll();
    }

    public List<Grade> getGradeById(Long id) {
        return iGradeClient.getGradeById(id);
    }

    public List<Grade> saveGrade(@RequestBody Grade grade) {
        return iGradeClient.saveGrade(grade);
    }

    public List<Grade> deleteGrade(Long id) {
        return iGradeClient.deleteGradeById(id);
    }

    public List<Grade> updateGrade(Long id, Grade grade) {
        return iGradeClient.updateGradeById(id, grade);
    }
}
