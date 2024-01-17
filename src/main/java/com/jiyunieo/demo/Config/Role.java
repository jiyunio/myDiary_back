package com.jiyunieo.demo.Config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role{
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    /*Role(String value) {
        this.value = value;
    }*/

    private final String value;
}