package com.jiyunieo.demo.Dto;

import lombok.Data;

@Data
public class ResponseDto {
    private Integer resId;
    private String msg;

    public ResponseDto(Integer resId, String msg) {
        this.resId = resId;
        this.msg = msg;
    }
}
