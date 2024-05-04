package com.javaGuide.organizationservice.controller;

import com.javaGuide.organizationservice.dto.OrganizationDto;
import com.javaGuide.organizationservice.entity.Organization;
import com.javaGuide.organizationservice.service.OrganizationService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
//import net.javaguides.organizationservice.dto.OrganizationDto;
//import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
//@RequestMapping("/organization")
@RequestMapping("api/organizations")
//@AllArgsConstructor
public class OrganizationController {

//    private OrganizationDto organizationDto;
    @Autowired
    private OrganizationService organizationService;
    @PostMapping("/createOrganization")
    public ResponseEntity<OrganizationDto>createOrganization(@RequestBody OrganizationDto organizationDto){
      OrganizationDto orgOutput=organizationService.createOrganization(organizationDto);
      return new ResponseEntity<>(orgOutput,HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<OrganizationDto> getOrganizationDetails(@PathVariable("id") String employeeId){
  OrganizationDto result=organizationService.getOrganizationDetails(employeeId);
  return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
