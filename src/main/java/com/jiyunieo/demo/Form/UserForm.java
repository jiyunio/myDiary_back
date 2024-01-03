package com.jiyunieo.demo.Form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.MessageInterpolator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserForm {
    @NotEmpty(message="이름을 작성해주세요.")
    private String name;

    @NotEmpty(message="아이디를 작성해주세요.")
    @Size(min=6, max=13)
    private String id;

    @NotEmpty(message="이메일을 작성해주세요.")
    private String email;

    @NotEmpty(message="비밀번호를 작성해주세요.")
    private String pw;

    @NotEmpty(message="비밀번호 확인을 작성해주세요.")
    private String check;
}
