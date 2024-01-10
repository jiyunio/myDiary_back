package com.jiyunieo.demo.Controller;

import com.jiyunieo.demo.Dto.LoginDto;
import com.jiyunieo.demo.Dto.SignupDto;
import com.jiyunieo.demo.Service.LoginService;
import com.jiyunieo.demo.Service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class TestController {
    //GetMapping : 주로 조회할 때 사용(url에 데이터를 포함시켜 요청)
    //PostMapping : 주로 노출되면 안되는 데이터를 저장할 때 사용(url에 데이터를 노출하지 않고 요청)

    private final SignupService signupService; // 서비스 이용을 위해 가져옴
    private final LoginService loginService;

    // 메인페이지
    @GetMapping("/")
    public String diaryMain(){
        return "Main/main_page";
    }

    //회원가입
    @GetMapping("/signup")
    public String signup(SignupDto signupDto) {
        return "Signup/signup_page";
    }

    @PostMapping("/signup") // html에서 submit하면 발동
    public String signup(Model model, @ModelAttribute @Valid SignupDto signupDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { // 오류 발생
            Map<String, String> validMap = signupService.valid_signup(bindingResult);
            for (String validName : validMap.keySet()) {
                model.addAttribute(validName, validMap.get(validName));
            }
            return "Signup/signup_page";
        }
        if(Objects.equals(signupDto.getUserPw(), signupDto.getCheckPw())){ // 비밀번호 비교
            if(signupService.create_signupUser(signupDto)){ // 로그인 성공
                model.addAttribute("name", signupDto.getUserName());
                return "Main/main_page";
            }
            else{
                model.addAttribute("error_userId", "이미 존재하는 아이디입니다.");
                return "Signup/signup_page";
            }
        }
        model.addAttribute("error_checkPw", "비밀번호가 일치하지 않습니다.");
        return "Signup/signup_page";
    }

    //로그인
    @GetMapping("/login")
    public String login(){
        return "Login/login_page";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute @Valid LoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){ // 유효성 검사 실패
            Map<String, String> validMap = loginService.valid_signin(bindingResult);
            for(String validName : validMap.keySet()){
                model.addAttribute(validName, validMap.get(validName));
            }
            return "Login/login_page";
        }
        else { // 검사 성공
            if (loginService.signin(loginDto)) { // 로그인 성공
               model.addAttribute("name", loginService.getUserName(loginDto));
               return "Main/main_page";
            } else { // 로그인 실패
                model.addAttribute("error_loginPw", "아이디 또는 비밀번호를 확인해주세요");
                return "Login/login_page";
            }
        }
    }
}