package com.archi.tp.api.clients;

import com.archi.tp.api.entities.Grade;
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
@FeignClient(name = "GradeClient")
public interface IGradeClient {
    @RequestLine("GET /")
    List<Grade> getAll();

    @RequestLine("GET /{id}")
    List<Grade> getGradeById(@Param("id") Long id);

    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    List<Grade> saveGrade(@RequestBody Grade grade);

    @RequestLine("DELETE /{id}")
    List<Grade> deleteGradeById(@Param("id") Long id);

    @RequestLine("PUT /{id}")
    @Headers("Content-Type: application/json")
    List<Grade> updateGradeById(@Param("id") Long id, @RequestBody Grade grade);
}
