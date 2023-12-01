package com.orivesolutions.hrms.interviewscheduler.domain;

import com.orivesolutions.hrms.interviewscheduler.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(name = "emailId", unique = true, nullable = false)
    private String emailId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;

    @Column
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private String profileUrl;

    @Column(name = "forgetToken", unique = true, nullable = true)
    private String forgetToken;

    @Column
    private Integer otp;

}
