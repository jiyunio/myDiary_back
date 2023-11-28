package com.jiyunieo.demo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class LoginUser {

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
