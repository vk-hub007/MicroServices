package com.javaGuide.employeeservice.service;

import com.javaGuide.employeeservice.dto.EmployeeDto;
import com.javaGuide.employeeservice.dto.ResponseDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ResponseDto getEmployeeById(Long employeeId);
}
