package com.orivesolutions.hrms.interviewscheduler.domain;

import com.orivesolutions.hrms.interviewscheduler.enums.InterviewStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;
    @OneToOne
    @JoinColumn(name = "interview_id", referencedColumnName = "id")
    private Interview interview;
    @Enumerated(EnumType.STRING)
    private InterviewStatus status;
    private String remarks;
    private Integer rating;

}
