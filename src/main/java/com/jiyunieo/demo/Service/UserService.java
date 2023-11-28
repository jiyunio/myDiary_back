package com.jiyunieo.demo.Service;

import ch.qos.logback.core.util.OptionHelper;
import com.jiyunieo.demo.LoginUser;
import com.jiyunieo.demo.Repository.UserRepository;
import com.jiyunieo.demo.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service // 서비스 : 엔티티 처리 메소드
public class UserService {
    private final UserRepository userRepository; // 데베와의 연결을 위해 JPA가 있는 레파지토리 사용

    public boolean isContainId(String UserId){ // id 중복 확인 메소드
        if(userRepository.existsByUserId(UserId)){
            return true;
        }
        else return false;
    }

    public boolean isCorrectPw(String userPw, String checkPw){ // pw 확인 메소드 / 먼저 작성한 pw1, 확인용 pw2
        if(userPw == checkPw) return true;
        else  return false;
    }
    public void create_User(String name, String email, String id, String pw) { // 새로운 유저 만들기
        LoginUser user = new LoginUser();
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserId(id);
        user.setUserPw(pw);
        this.userRepository.save(user); // 레파지토리에 현재 만든 user 저장
    }
}
