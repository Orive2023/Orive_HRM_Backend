package com.orivesolutions.hrms.interviewscheduler.service;

import com.orivesolutions.hrms.interviewscheduler.domain.Candidate;
import com.orivesolutions.hrms.interviewscheduler.dto.CandidateDto;

public interface CandidateService {

    CandidateDto createCandidate(CandidateDto candidateDto);

    CandidateDto getCandidate(String email);

    Candidate findCandidateByEmail(String email);


}
