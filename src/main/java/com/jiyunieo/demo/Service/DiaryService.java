package com.jiyunieo.demo.Service;

import com.jiyunieo.demo.Domain.Diary;
import com.jiyunieo.demo.Domain.Member;
import com.jiyunieo.demo.Dto.DiaryDto;
import com.jiyunieo.demo.Repository.DiaryRepository;
import com.jiyunieo.demo.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiaryService {
    private final MemberRepository memberRepository;
    private final DiaryRepository diaryRepository;

    public Integer create(Integer id, DiaryDto diaryDto) {
        Member member = memberRepository.findById(id).get();
        Diary diary = new Diary();
        diary.setUserId(member.getUserId());
        diary.setContents(diaryDto.getContents());
        diary.setX(diaryDto.getX());
        diary.setY(diaryDto.getY());
        return diaryRepository.save(diary).getId();
    }

    public Integer update(Integer id, DiaryDto diaryDto) {
        Diary diary = diaryRepository.findById(id).get();
        diary.update(diaryDto.getContents(), diaryDto.getX(), diaryDto.getY());
        return diaryRepository.save(diary).getId();
    }

    public void delete(Integer id) {
        diaryRepository.deleteById(id);
        log.warn("다이어리 요소 삭제 성공");
    }
}
