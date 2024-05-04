package com.javaGuide.organizationservice.service.impl;

import com.javaGuide.organizationservice.dto.OrganizationDto;
import com.javaGuide.organizationservice.entity.Organization;
import com.javaGuide.organizationservice.repository.OrganizationRepository;
import com.javaGuide.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization=new Organization(organizationDto.getId(),organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate());
        Organization response=organizationRepository.save(organization);
        return new OrganizationDto(response.getId(),response.getOrganizationName(),response.getOrganizationDescription(),response.getOrganizationCode(),response.getCreatedDate());

    }

    @Override
    public OrganizationDto getOrganizationDetails(String id) {
        Organization result=organizationRepository.findByOrganizationCode(id);
        return new OrganizationDto(
                result.getId(),
                result.getOrganizationName(),
                result.getOrganizationDescription(),
                result.getOrganizationCode(),
                result.getCreatedDate()
        );
    }
}
