package com.jiyunieo.demo.Dto;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class LoginDto {
    @Id
    Integer id;

    @NotBlank(message = "아이디를 작성해주세요.")
    String loginId;

    @NotBlank(message = "비밀번호를 작성해주세요.")
    String loginPw;
}
