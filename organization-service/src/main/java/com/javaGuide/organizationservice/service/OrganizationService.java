package com.javaGuide.organizationservice.service;

import com.javaGuide.organizationservice.dto.OrganizationDto;
import com.javaGuide.organizationservice.entity.Organization;

public interface OrganizationService {
     OrganizationDto createOrganization(OrganizationDto organizationDto);
     OrganizationDto getOrganizationDetails(String id);

}
