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
    //@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{6,13}", message = "x아이디 : 공백을 포함하지 않고 6~13자의 영문 대/소문자, 숫자를 모두 사용해주세요.")
    // 유효성 검사
    private String userId;

    @NotBlank
    // 유효성 검사
    private String userPw;

    @NotBlank
    private String checkPw;
}
