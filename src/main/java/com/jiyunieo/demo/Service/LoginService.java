package com.jiyunieo.demo.Service;

import com.jiyunieo.demo.Domain.SignupUser;
import com.jiyunieo.demo.Dto.LoginDto;
import com.jiyunieo.demo.Dto.SignupDto;
import com.jiyunieo.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;

    public boolean signin(LoginDto inDto){ // 로그인
        if(this.userRepository.existsByUserId(inDto.getLoginId())){
            Optional<SignupUser> upData = this.userRepository.findByUserId(inDto.getLoginId());
            SignupUser up = upData.get();
            return Objects.equals(up.getUserPw(), inDto.getLoginPw());
        }
        return false;
    }

    public String getUserName(LoginDto loginDto){
        Optional<SignupUser> signupData = this.userRepository.findByUserId(loginDto.getLoginId()); // 엔티티 사용 VVVV
        SignupUser up = signupData.get();
        return up.getUserName();
    }

    public Map<String, String> valid_signin(Errors erros){
        Map<String, String> m = new HashMap<>();

        for(FieldError fieldError : erros.getFieldErrors()){
            String field = fieldError.getField();
            m.put("error_"+field, fieldError.getDefaultMessage());
        }
        return m;
    }
}
