package com.javaGuide.organizationservice.repository;

import com.javaGuide.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String orgCode);

}
