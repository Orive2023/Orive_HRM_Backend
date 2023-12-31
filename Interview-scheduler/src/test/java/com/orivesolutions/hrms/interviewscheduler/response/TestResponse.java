package com.orivesolutions.hrms.interviewscheduler.response;

import com.orivesolutions.hrms.interviewscheduler.domain.Candidate;
import com.orivesolutions.hrms.interviewscheduler.dto.CandidateDto;

public class TestResponse {

    public static Candidate getCandidate() {
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

    public static CandidateDto getCandidateDto() {
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
