package com.jiyunieo.demo.Dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

@Data
public class DiaryDto {
    @Id
    private Integer id;

    private String content;
}
