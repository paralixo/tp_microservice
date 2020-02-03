package com.archi.tp.gradestudents.clients;

import com.archi.tp.gradestudents.entities.Grade;
import com.archi.tp.gradestudents.entities.Student;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "StudentClient")
public interface IStudentClient {
    @RequestLine("GET /")
    List<Student> getStudents();
}
