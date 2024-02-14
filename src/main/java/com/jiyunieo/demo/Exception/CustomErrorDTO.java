package com.jiyunieo.demo.Exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class CustomErrorDTO {
    private String code;
    private String msg;
    private String detail;

    public static ResponseEntity<CustomErrorDTO> toResponseEntity(CustomException ex) {
        CustomErrorCode errorType = ex.getErrorCode();

        return ResponseEntity
                .status(ex.getStatus())
                .body(CustomErrorDTO.builder()
                        .code(errorType.getCode())
                        .msg(errorType.getMsg())
                        .build());
    }
}
