package com.jiyunieo.demo.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomErrorCode {
    // 에러 발생 시, 프론트에게 전달할 에러 코드 관리

    // 400 error
    USER_ID_ERROR("000_USER_ID_ERROR", "아이디가 존재합니다."),
    USER_EMAIL_ERROR("001_USER_EMAIL_ERROR", "이메일이 존재합니다."),
    CHECK_PW_ERROR("002_CHECK_PW_ERROR", "비밀번호가 일치하지 않습니다."),
    INVALID_PW("003_INVALID_PW", "유효하지 않은 비밀번호입니다."),

    NOT_USER_ID("004_NOT_USER_ID", "아이디가 존재하지 않습니다."),
    NOT_MATCH_PW("005_NOT_MATCH_PW", "비밀번호가 맞지 않습니다.");

    private final String code;
    private final String msg;
}
