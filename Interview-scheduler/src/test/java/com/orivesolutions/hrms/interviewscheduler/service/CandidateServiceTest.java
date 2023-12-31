package com.orivesolutions.hrms.interviewscheduler.service;

import com.orivesolutions.hrms.interviewscheduler.domain.Candidate;
import com.orivesolutions.hrms.interviewscheduler.dto.CandidateDto;
import com.orivesolutions.hrms.interviewscheduler.mapper.CandidateMapper;
import com.orivesolutions.hrms.interviewscheduler.mapper.CandidateMapperImpl;
import com.orivesolutions.hrms.interviewscheduler.repository.CandidateRepository;
import com.orivesolutions.hrms.interviewscheduler.service.impl.CandidateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {CandidateServiceImpl.class, CandidateMapperImpl.class})
@ExtendWith(SpringExtension.class)
public class CandidateServiceTest {

    @MockBean
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private CandidateServiceImpl underTestService;

//    @Test
//    public void test_createCandidate() {
//
//        Candidate expectedCandidate = getCandidate();
//
//        //when
//        Mockito.when(candidateRepository.save(Mockito.any(Candidate.class))).thenReturn(expectedCandidate);
//
//        CandidateDto candidateInput = getCandidateDto();
//        String resultantCandidate = underTestService.saveCandidate(candidateInput);
//
//
//        Assertions.assertNotNull(resultantCandidate);
//        Assertions.assertEquals("contact.rohan@codeglancer.com", resultantCandidate.getEmail());
//
//        verify(candidateRepository, times(1)).save(Mockito.any(Candidate.class));
//    }

    @Test
    public void test_findCandidateByEmail() {
        Candidate expectedCandidate = getCandidate();

        // when
        Mockito.when(candidateRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(expectedCandidate));
        // to be tested
        Candidate resultantCandidate = underTestService.findCandidateByEmail("contact.rohan@codeglancer.com");
        /// assertion
        Assertions.assertNotNull(resultantCandidate);
        Assertions.assertEquals(expectedCandidate.getName(), resultantCandidate.getName());


    }

    public Candidate getCandidate() {
        return Candidate.builder()
                .id(Long.valueOf(111))
                .name("Rohan Kumar")
                .address("Phesar")
                .email("contact.rohan@codeglancer.com")
                .mobile("9999999999")
                .ctc(30000000)
                .ectc(4000000)
                .location("Prayag Raj")
                .notice("60 days negotiable")
                .build();
    }

    public CandidateDto getCandidateDto() {
        return CandidateDto.builder()
                .name("Rohan Kumar")
                .address("Phesar")
                .email("contact.rohan@codeglancer.com")
                .mobile("9999999999")
                .ctc(30000000)
                .ectc(4000000)
                .location("Prayag Raj")
                .notice("60 days negotiable")
                .build();
    }
}
