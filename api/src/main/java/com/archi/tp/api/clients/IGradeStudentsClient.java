package com.archi.tp.api.clients;

import com.archi.tp.api.entities.GradeStudentsDTO;
import com.archi.tp.api.entities.Student;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(name = "StudentClient")
public interface IGradeStudentsClient {
    @RequestLine("GET /")
    List<GradeStudentsDTO> getAllGradeStudents();

    @RequestLine("GET /{id}")
    GradeStudentsDTO getGradeStudentsById(@Param("id") Long id);
}