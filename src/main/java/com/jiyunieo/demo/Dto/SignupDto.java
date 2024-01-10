package com.jiyunieo.demo.Dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignupDto {

    private Integer id;

    @NotBlank(message = "이름을 작성해주세요.")
    private String userName;

    @NotBlank(message = "이메일을 작성해주세요.")
    @Email
    private String userEmail;

    @NotBlank(message = "아이디를 작성해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{6,13}", message = "아이디 : 공백을 포함하지 않고 6~13자의 영문 대/소문자, 숫자를 모두 사용해주세요.")
    // 유효성 검사
    private String userId;

    @NotBlank(message = "비밀번호를 작성해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,13}", message = "비밀번호 : 공백을 포함하지 않고 6~13자의 영문 대/소문자, 숫자, 특수문자를 모두 사용해주세요.")
    // 유효성 검사
    private String userPw;

    @NotBlank(message = "비밀번호 확인을 작성해주세요.")
    private String checkPw;
}
