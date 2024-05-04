package com.javaGuide.departmentservice.controller;

import com.javaGuide.departmentservice.dto.DepartmentDto;
import com.javaGuide.departmentservice.entity.Department;
import com.javaGuide.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/department")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveRecord(@RequestBody DepartmentDto departmentDto){
        DepartmentDto output=departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
    @PostMapping("/saveUsingEntity")
    private ResponseEntity<Department>saveEntityRecord(@RequestBody Department department){
        Department op=departmentService.saveDepartmentUsingEntity(department);
        return new ResponseEntity<>(op,HttpStatus.OK);
    }
    @GetMapping("{departmentCode}")
    private ResponseEntity<DepartmentDto>getDepartmentDetails(@PathVariable("departmentCode") String code){
        DepartmentDto output=departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(output,HttpStatus.OK);


    }
    // Build get department rest api
//    @GetMapping("{department-code}")
//    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
//        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
//        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
//    }
}
