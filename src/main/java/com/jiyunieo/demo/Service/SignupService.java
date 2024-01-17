package com.jiyunieo.demo.Service;

import com.jiyunieo.demo.Domain.Member;
import com.jiyunieo.demo.Dto.MemberDto;
import com.jiyunieo.demo.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service // 서비스 : 엔티티 처리 메소드
public class SignupService {
    private final MemberRepository memberRepository; // 데베와의 연결을 위해 JPA가 있는 레파지토리 사용
    private final PasswordEncoder passwordEncoder;

    public boolean create_signupUser(MemberDto memberDto) {
        if (memberRepository.existsByUserId(memberDto.getUserId())) {// 아이디 중복검사
            return false;
        } else {// 새로운 유저 만들기
            Member user = new Member();
            user.setUserName(memberDto.getUserName());
            user.setUserEmail(memberDto.getUserEmail());
            user.setUserId(memberDto.getUserId());
            user.setUserPw(passwordEncoder.encode(memberDto.getUserPw()));
            this.memberRepository.save(user); // 레파지토리에 현재 만든 user 저장
            return true;
        }
    }

    public Map<String, String> valid_signup(Errors errors){
        Map<String, String> m = new HashMap<>();

        for(FieldError fieldError : errors.getFieldErrors()) {
            String errorField = fieldError.getField();
            m.put("error_"+errorField, fieldError.getDefaultMessage());
            // 유효성 검사 실패가 된 변수와 해당 실패에 대한 message 저장
        }
        return m;
    }
}