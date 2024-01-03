package com.jiyunieo.demo.controller;

import com.jiyunieo.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final UserService userService; // 서비스 이용을 위해 가져옴

    @GetMapping("/signup")
    public String signup() {
        return "signup_page";
    }
    //GetMapping : 주로 조회할 때 사용(url에 데이터를 포함시켜 요청)
    //PostMapping : 주로 노출되면 안되는 데이터를 저장할 때 사용(url에 데이터를 노출하지 않고 요청)

    @PostMapping("/signup") // html에서 submit하면 발동
    public String signup(Model model, @RequestParam("userName") String name, @RequestParam("userEmail") String email, @RequestParam("userId") String id,
                         @RequestParam("userPw") String pw, @RequestParam("checkPw") String check) {
        if (this.userService.checkBlank(name, email, id, pw, check)) {
            return "fail_blank";
        } else {
            if (!this.userService.isContainId(id)) { // 해당 id가 존재하지 않으면
                if (Objects.equals(pw, check)) { // 비번이랑 비번확인용이랑 같으면
                    this.userService.create_User(name, email, id, pw);
                    model.addAttribute("name", name);
                    return "signup_success";
                } else { // 다르면 오류창 내보내기
                    return "fail_pw";
                }
            } else { // 해당 id가 존재
                return "fail_id"; // 이미 존재하는 id라는 오류창 내보내기
            }
        }
    }
}