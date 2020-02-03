package com.archi.tp.gradestudents.services;

import com.archi.tp.gradestudents.clients.IGradeClient;
import com.archi.tp.gradestudents.clients.IStudentClient;
import com.archi.tp.gradestudents.entities.Grade;
import com.archi.tp.gradestudents.entities.GradeStudentsDTO;
import com.archi.tp.gradestudents.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Data
public class GradeStudentsService {
    private IStudentClient iStudentClient = Feign.builder()
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

    public GradeStudentsDTO getGradeStudents(Long gradeId) {
        List<Grade> grade = iGradeClient.getGradeById(gradeId);

        List<Student> students = iStudentClient.getStudents()
                .stream()
                .filter(s -> s.getGrade() == gradeId)
                .collect(Collectors.toList());

        return new GradeStudentsDTO(grade.get(0), students);
    }

    public List<GradeStudentsDTO> getGradesAndStudents() {
        List<GradeStudentsDTO> result = new ArrayList<>();
        List<Grade> grades = iGradeClient.getAll();

        grades.forEach(grade -> {
            List<Student> students = iStudentClient.getStudents()
                    .stream()
                    .filter(s -> s.getGrade() == grade.getId())
                    .collect(Collectors.toList());
            result.add(new GradeStudentsDTO(grade, students));
        });

        return result;
    }
}
