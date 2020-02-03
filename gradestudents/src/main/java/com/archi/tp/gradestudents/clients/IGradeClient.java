package com.archi.tp.gradestudents.clients;

import com.archi.tp.gradestudents.entities.Grade;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "GradeClient")
public interface IGradeClient {
    @RequestLine("GET /")
    List<Grade> getAll();

    @RequestLine("GET /{id}")
    List<Grade> getGradeById(@Param(value = "id") Long id);
}
