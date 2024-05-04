package com.javaGuide.employeeservice.service.impl;

import com.javaGuide.employeeservice.dto.DepartmentDto;
import com.javaGuide.employeeservice.dto.EmployeeDto;
import com.javaGuide.employeeservice.dto.OrganizationDto;
import com.javaGuide.employeeservice.dto.ResponseDto;
import com.javaGuide.employeeservice.entity.Employee;
import com.javaGuide.employeeservice.mapper.EmployeeMapper;
import com.javaGuide.employeeservice.repository.EmployeeRepository;
import com.javaGuide.employeeservice.service.ApiFeign;
import com.javaGuide.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.apache.juli.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
    private WebClient webClient;
//      private ApiFeign apiFeign;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);
        return savedEmployeeDto;
    }
//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("inside getEmployee method");
        Employee employeeDto=employeeRepository.findById(employeeId).get();
//     ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8081/department/"+employeeDto.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto=apiFeign.getDepartmentDetails(employeeDto.getDepartmentCode());
//                apiFeign.getOrganizationDetails(employeeDto.getOrganizationCode());

DepartmentDto departmentDto=webClient
        .get()
        .uri("http://localhost:8081/department/"+employeeDto.getDepartmentCode())
        .retrieve()
        .bodyToMono(DepartmentDto.class)
        .block();
        ResponseDto responseDto=new ResponseDto();
        OrganizationDto organizationresponse=
                webClient
                        .get()
                        .uri("http://localhost:8085/api/organizations/"+employeeDto.getOrganizationCode())
                        .retrieve()
                        .bodyToMono(OrganizationDto.class)
                        .block();
     EmployeeDto empDto= EmployeeMapper.mapToEmployeeDto(employeeDto);
        responseDto.setEmployeeDto(empDto);
        responseDto.setDepartmentDto(departmentDto);
        responseDto.setOrganizationDto(organizationresponse);
        return responseDto;
    }
    public ResponseDto getDefaultDepartment(Long employeeId,Exception exception) {
        LOGGER.info("inside getDefaultDepartment method");
        Employee employeeDto=employeeRepository.getReferenceById(employeeId);

//DepartmentDto departmentDto=webClient
//        .get()
//        .uri("http://localhost:8081/department/"+employeeDto.getDepartmentCode())
//        .retrieve()
//        .bodyToMono(DepartmentDto.class)
//        .block();
//        DepartmentDto departmentDto=apiFeign.getDepartmentDetails(employeeDto.getDepartmentCode());
        DepartmentDto departmentDto=new DepartmentDto();
        departmentDto.setDepartmentCode("IT");
        departmentDto.setDepartmentDescription("default implementation");
        departmentDto.setId(20);
        departmentDto.setDepartmentName("VK");
        ResponseDto responseDto=new ResponseDto();
        EmployeeDto empDto= EmployeeMapper.mapToEmployeeDto(employeeDto);
        responseDto.setEmployeeDto(empDto);
        responseDto.setDepartmentDto(departmentDto);
        return responseDto;
    }
}
//    @Override
//    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = new Employee(employeeDto.getId(),
//                employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail(),employeeDto.getDepartmentCode(),employeeDto.getOrganizationCode());
//
//
//        Employee saveDEmployee = employeeRepository.save(employee);
//
//        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);
//
//        return savedEmployeeDto;
//}
