package com.orivesolutions.hrms.interviewscheduler.mapper;

import com.orivesolutions.hrms.interviewscheduler.domain.Candidate;
import com.orivesolutions.hrms.interviewscheduler.dto.CandidateDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-25T12:42:09+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public CandidateDto toCandidateDto(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateDto candidateDto = new CandidateDto();

        candidateDto.setId( candidate.getId() );
        candidateDto.setName( candidate.getName() );
        candidateDto.setAddress( candidate.getAddress() );
        candidateDto.setEmail( candidate.getEmail() );
        candidateDto.setMobile( candidate.getMobile() );
        candidateDto.setCtc( candidate.getCtc() );
        candidateDto.setEctc( candidate.getEctc() );
        candidateDto.setLocation( candidate.getLocation() );
        candidateDto.setNotice( candidate.getNotice() );
        candidateDto.setResumeUrl( candidate.getResumeUrl() );

        return candidateDto;
    }

    @Override
    public Candidate toCandidate(CandidateDto candidateDto) {
        if ( candidateDto == null ) {
            return null;
        }

        Candidate candidate = new Candidate();

        candidate.setId( candidateDto.getId() );
        candidate.setName( candidateDto.getName() );
        candidate.setAddress( candidateDto.getAddress() );
        candidate.setEmail( candidateDto.getEmail() );
        candidate.setMobile( candidateDto.getMobile() );
        candidate.setCtc( candidateDto.getCtc() );
        candidate.setEctc( candidateDto.getEctc() );
        candidate.setLocation( candidateDto.getLocation() );
        candidate.setNotice( candidateDto.getNotice() );
        candidate.setResumeUrl( candidateDto.getResumeUrl() );

        return candidate;
    }
}
