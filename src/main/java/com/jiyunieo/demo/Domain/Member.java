package com.jiyunieo.demo.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userName", length = 13)
    private String userName;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userId", length = 13)
    private String userId;

    @Column(name = "userPw")
    private String userPw;

    public void updatePw(String userPw) {
        this.userPw = userPw;
    }

}
