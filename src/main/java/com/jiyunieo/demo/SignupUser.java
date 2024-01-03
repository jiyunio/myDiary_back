package com.jiyunieo.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class SignupUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UserName", length = 13)
    private String userName;

    @Column(name = "UserEmail")
    private String userEmail;

    @Column(name = "UserId", length = 10)
    private String userId;

    @Column(name = "UserPw", length = 10)
    private String userPw;
}
