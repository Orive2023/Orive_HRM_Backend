package com.orivesolutions.hrms.interviewscheduler.service.impl;

import com.orivesolutions.hrms.interviewscheduler.domain.Candidate;
import com.orivesolutions.hrms.interviewscheduler.dto.CandidateDto;
import com.orivesolutions.hrms.interviewscheduler.exception.ResourceNotFoundException;
import com.orivesolutions.hrms.interviewscheduler.mapper.CandidateMapper;
import com.orivesolutions.hrms.interviewscheduler.repository.CandidateRepository;
import com.orivesolutions.hrms.interviewscheduler.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public CandidateDto createCandidate(CandidateDto candidateDto) {
        Candidate candidate = candidateMapper.toCandidate(candidateDto);
        candidate = candidateRepository.save(candidate);
        candidateDto = candidateMapper.toCandidateDto(candidate);
        return candidateDto;
    }

    @Override
    public CandidateDto getCandidate(String email) {
        Candidate candidate = candidateRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Candidate not found", HttpStatus.NOT_FOUND));
        CandidateDto candidateDto = candidateMapper.toCandidateDto(candidate);
        return candidateDto;
    }

    @Override
    public Candidate findCandidateByEmail(String email) {
        Candidate candidate = candidateRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Candidate not found", HttpStatus.NOT_FOUND));
        return candidate;
    }
}
