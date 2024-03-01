package com.jiyunieo.demo.Controller;

import com.jiyunieo.demo.Dto.LoginDto;
import com.jiyunieo.demo.Dto.MemberDto;
import com.jiyunieo.demo.Dto.MemberUpdateDto;
import com.jiyunieo.demo.Dto.ResponseDto;
import com.jiyunieo.demo.Service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService; // 서비스 이용을 위해 가져옴

    // 회원 생성
    @PostMapping("/signup")
    @ApiOperation(value = "회원 추가", notes = "회원가입합시다.")
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody MemberDto memberDto) {
        Integer id = memberService.create(memberDto);
        return ResponseEntity.ok(new ResponseDto(id, "회원가입 성공"));
    }

    //회원 수정
    @PatchMapping("/member/{id}")
    @ApiOperation(value = "회원 수정", notes = "id : 회원의 ID / 회원의 비밀번호 수정을 합니다.")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id, @RequestBody MemberUpdateDto updateDto) {
        memberService.update(id, updateDto);
        return ResponseEntity.ok(new ResponseDto(id, "회원수정 성공"));
    }

    //회원 삭제
    @DeleteMapping("/member/{id}")
    @ApiOperation(value = "회원 삭제", notes = "id : 회원의 ID / 회원를 삭제합니다.")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        memberService.delete(id);
        return ResponseEntity.ok("회원삭제 성공");
    }

    //로그인
    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "로그인합시다.")
    public ResponseEntity<ResponseDto> login(@Valid @RequestBody LoginDto loginDto) {
        Integer id = memberService.login(loginDto);
        log.warn("로그인 성공");
        return ResponseEntity.ok(new ResponseDto(id, "로그인 성공"));
    }
}