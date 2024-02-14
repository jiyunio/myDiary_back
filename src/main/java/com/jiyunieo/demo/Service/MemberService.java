package com.jiyunieo.demo.Service;

import com.jiyunieo.demo.Domain.Member;
import com.jiyunieo.demo.Dto.MemberDto;
import com.jiyunieo.demo.Exception.CustomErrorCode;
import com.jiyunieo.demo.Exception.CustomException;
import com.jiyunieo.demo.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository; // 데베와의 연결을 위해 JPA가 있는 레파지토리 사용
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Integer create_signupUser(MemberDto memberDto) {
        if (memberRepository.existsByUserId(memberDto.getUserId())) {// 아이디 중복 검사
            throw new CustomException(HttpStatus.BAD_REQUEST, CustomErrorCode.USER_ID_ERROR);
        }
        if (memberRepository.existsByUserEmail(memberDto.getUserEmail())) { // 이메일 중복 검사
            throw new CustomException(HttpStatus.BAD_REQUEST, CustomErrorCode.USER_EMAIL_ERROR);
        }
        if (!Objects.equals(memberDto.getUserPw(), memberDto.getCheckPw())) { // 비밀번호 체크
            throw new CustomException(HttpStatus.BAD_REQUEST, CustomErrorCode.CHECK_PW_ERROR);
        } else {// 새로운 유저 만들기
            Member user = new Member();
            user.setUserName(memberDto.getUserName());
            user.setUserEmail(memberDto.getUserEmail());
            user.setUserId(memberDto.getUserId());
            user.setUserPw(passwordEncoder.encode(memberDto.getUserPw())); // 비밀번호 암호화
            return memberRepository.save(user).getId(); // 레파지토리에 현재 만든 user 저장
        }
    }

    @Transactional
    public Integer login(String loginId, String loginPw) {
        if (!memberRepository.existsByUserId(loginId)) { // 아이디 존재 여부
            log.warn("아이디 존재 X");
            throw new CustomException(HttpStatus.BAD_REQUEST, CustomErrorCode.NOT_USER_ID);
        }

        Member member = memberRepository.findByUserId(loginId).get();
        if (!passwordEncoder.matches(loginPw, member.getUserPw())) { // 비밀번호 복호화 비교
            log.warn("비밀번호 틀림");
            throw new CustomException(HttpStatus.BAD_REQUEST, CustomErrorCode.NOT_MATCH_PW);
        } else {
            return member.getId();
        }
    }
}