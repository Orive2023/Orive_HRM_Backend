package com.orivesolutions.hrms.interviewscheduler.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "candidate")
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "emailId", unique = true, nullable = false)
    private String email;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "ctc")
    private Integer ctc;
    
    @Column(name = "ectc")
    private Integer ectc;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "notice")
    private String notice;
    
    @Lob
    @Column(name = "resume_url",length = 100000)
    private byte[] resumeUrl;
}
