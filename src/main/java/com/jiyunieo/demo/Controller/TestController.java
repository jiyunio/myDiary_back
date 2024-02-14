package com.jiyunieo.demo.Controller;

import com.jiyunieo.demo.Dto.DiaryDto;
import com.jiyunieo.demo.Dto.MemberDto;
import com.jiyunieo.demo.Dto.ResponseDto;
import com.jiyunieo.demo.Service.DiaryService;
import com.jiyunieo.demo.Service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {
    private final MemberService memberService; // 서비스 이용을 위해 가져옴
    private final DiaryService diaryService;
    // 회원가입
    @PostMapping("/signup")
    @ApiOperation(value = "회원가입", notes = "회원가입합시다.")
    public ResponseEntity<ResponseDto> signup(@Valid @RequestBody MemberDto memberDto) {
        Integer id = memberService.create_signupUser(memberDto);
        return ResponseEntity.ok(new ResponseDto(id, "회원가입 성공"));
    }

    //로그인
    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "로그인합시다.")
    public ResponseEntity<ResponseDto> login(@Valid @RequestParam("loginId") String loginId, @RequestParam("loginPw") String loginPw){
        Integer id = memberService.login(loginId, loginPw);
        log.warn("로그인 성공");
        return ResponseEntity.ok(new ResponseDto(id, "로그인 성공"));
    }

    //다이어리
    @PostMapping("/diary")
    @ApiOperation(value = "다이어리", notes = "내용, 요소 좌표 저장")
    public ResponseEntity<ResponseDto> diary(@Valid @RequestBody DiaryDto diaryDto){
        Integer id = diaryService.crete(diaryDto);
        return ResponseEntity.ok(new ResponseDto(id, "다이어리 변경 성공"));
    }
}