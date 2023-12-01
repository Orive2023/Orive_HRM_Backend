package com.orivesolutions.hrms.interviewscheduler.mapper;

import com.orivesolutions.hrms.interviewscheduler.domain.Candidate;
import com.orivesolutions.hrms.interviewscheduler.dto.CandidateDto;
import org.mapstruct.Mapper;

@Mapper
public interface CandidateMapper {

    CandidateDto toCandidateDto(Candidate candidate);

    Candidate toCandidate(CandidateDto candidateDto);

}
