package com.archi.tp.api.clients;

import com.archi.tp.api.entities.Student;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "StudentClient")
public interface IStudentClient {
    @RequestLine("GET /")
    List<Student> getAll();

    @RequestLine("GET /{id}")
    List<Student> getStudentById(@Param("id") Long id);

    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    List<Student> saveStudent(@RequestBody Student student);

    @RequestLine("DELETE /{id}")
    List<Student> deleteStudentById(@Param("id") Long id);

    @RequestLine("PUT /{id}")
    @Headers("Content-Type: application/json")
    List<Student> updateStudentById(@Param("id") Long id, @RequestBody Student student);
}
