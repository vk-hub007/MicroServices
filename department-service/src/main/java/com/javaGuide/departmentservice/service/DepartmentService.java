package com.javaGuide.departmentservice.service;

import com.javaGuide.departmentservice.dto.DepartmentDto;
import com.javaGuide.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto  departmentDto);

    Department saveDepartmentUsingEntity(Department department);
    DepartmentDto getDepartmentByCode(String code);

}
