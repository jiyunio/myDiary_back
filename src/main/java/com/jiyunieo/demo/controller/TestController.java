package com.jiyunieo.demo.controller;

import com.jiyunieo.demo.Repository.UserRepository;
import com.jiyunieo.demo.Service.UserService;
import com.jiyunieo.demo.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final UserService userService; // 서비스 이용을 위해 가져옴

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    //GetMapping : 주로 조회할 때 사용(url에 데이터를 포함시켜 요청)
    //PostMapping : 주로 노출되면 안되는 데이터를 저장할 때 사용(url에 데이터를 노출하지 않고 요청)

    @PostMapping("/login") // html에서 submit하면 발동
    public String login(Model model, @RequestParam("userName") String name, @RequestParam("userEmail") String email, @RequestParam("userId") String id, @RequestParam("userPw") String pw, @RequestParam("checkPw") String check) {
        this.userService.create_User(name, email, id, pw);
        model.addAttribute("name", name);
        return "loginSuccess";

    }
}