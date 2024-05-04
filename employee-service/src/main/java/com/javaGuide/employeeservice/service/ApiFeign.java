package com.javaGuide.employeeservice.service;

import com.javaGuide.employeeservice.dto.DepartmentDto;
import com.javaGuide.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8081/",value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
/*
above i commented feign client to achieve load balancing
we registerd department service with 2 ports on 8081,8181
second feign client tells if we down 8081 and call employee to department, it internally calls
department serive on 8181-this to achieve load balancing
 */
public interface ApiFeign {
    @GetMapping("/department/{departmentCode}")
    DepartmentDto getDepartmentDetails(@PathVariable("departmentCode") String code);

    @GetMapping("/api/organizations/{orgCode}")
    OrganizationDto getOrganizationDetails(@PathVariable ("orgCode") String orCode);

    }

