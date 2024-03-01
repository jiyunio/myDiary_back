package com.jiyunieo.demo.Controller;

import com.jiyunieo.demo.Dto.DiaryDto;
import com.jiyunieo.demo.Dto.ResponseDto;
import com.jiyunieo.demo.Service.DiaryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class DiaryController {

    private final DiaryService diaryService;

    // 생성
    @PostMapping("/diary/{memberId}") // id : 회원의 id
    @ApiOperation(value = "다이어리 요소 생성", notes = "memberId : 회원의 ID")
    public ResponseEntity<ResponseDto> create(@PathVariable Integer memberId, @Valid @RequestBody DiaryDto diaryDto) {
        Integer id = diaryService.create(memberId, diaryDto);
        return ResponseEntity.ok(new ResponseDto(id, "다이어리 요소 생성 성공"));
    }

    // 수정
    @PutMapping("/diary/{memberId}/{elementId}")
    @ApiOperation(value = "다이어리 요소 수정", notes = "memberId : 회원의 ID / elementId : 다이어리 요소의 ID")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer elementId, @Valid @RequestBody DiaryDto diaryDto) {
        Integer id = diaryService.update(elementId, diaryDto);
        return ResponseEntity.ok(new ResponseDto(id, "다이어리 요소 변경 성공"));
    }

    // 삭제
    @DeleteMapping("/diary/{memberId}/{elementId}")
    @ApiOperation(value = "다이어리 요소 삭제", notes = "memberId : 회원의 ID / elementId : 다이어리 요소의 ID")
    public ResponseEntity<String> delete(@PathVariable Integer elementId) {
        diaryService.delete(elementId);
        return ResponseEntity.ok("다이어리 요소 삭제 성공");
    }
}
