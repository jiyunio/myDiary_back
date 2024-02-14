package com.jiyunieo.demo.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    // 예외 전달 시, 상세한 에러 정보 전달
    private final HttpStatus status;
    private final CustomErrorCode errorCode;

    public CustomException(HttpStatus status, CustomErrorCode errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }
}
