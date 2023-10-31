package com.orive.Recruitment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orive.Recruitment.Entity.JobsListingFrontendEntity;

public interface JobsListingFrontendRepository extends JpaRepository<JobsListingFrontendEntity, Long> {

}
