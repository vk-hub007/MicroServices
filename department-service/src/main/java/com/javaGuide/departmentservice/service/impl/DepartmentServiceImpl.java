package com.javaGuide.departmentservice.service.impl;

import com.javaGuide.departmentservice.dto.DepartmentDto;
import com.javaGuide.departmentservice.entity.Department;
import com.javaGuide.departmentservice.repository.DepartmentRepository;
import com.javaGuide.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
      Department output=departmentRepository.save(department);

        DepartmentDto savedDepartment=new DepartmentDto(
                output.getId(),
                output.getDepartmentName(),
                output.getDepartmentDescription(),
                output.getDepartmentCode()
        );
        return savedDepartment;
    }
    @Override
    public Department saveDepartmentUsingEntity(Department department){
        Department output=departmentRepository.save(department);
        return output;
    }

//    @Override
//    public DepartmentDto getDepartmentByCode(String code) {
//        Department output=departmentRepository.findByDepartmentCode(code);
//        DepartmentDto op=new DepartmentDto(
//                output.getId(),
//                output.getDepartmentName(),
//                output.getDepartmentDescription(),
//                output.getDepartmentCode()
//        );
//        return op;
//    }
    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department output = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto =new DepartmentDto(
                output.getId(),
                output.getDepartmentName(),
                output.getDepartmentDescription(),
                output.getDepartmentCode()
        );

        return departmentDto;
    }
}
