package com.jiyunieo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class TestController {
    @GetMapping
    public String hello() {
        return "hello";
    }
    @GetMapping("/name")
    public String name() {
        return "name";
    }
}