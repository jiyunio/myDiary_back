package com.jiyunieo.demo.Dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class MemberDto {
    @NotBlank
    private String userName;

    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    private String userId;

    @NotBlank
    private String userPw;

    @NotBlank
    private String checkPw;
}
