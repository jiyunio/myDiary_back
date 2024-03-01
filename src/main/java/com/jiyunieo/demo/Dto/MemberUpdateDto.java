package com.jiyunieo.demo.Dto;

import lombok.Data;

@Data
public class MemberUpdateDto {
    private String userPw;
    private String changePw;
    private String checkChangePw;
}
