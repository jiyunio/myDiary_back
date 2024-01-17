package com.jiyunieo.demo.Service;

import com.jiyunieo.demo.Domain.Diary;
import com.jiyunieo.demo.Dto.DiaryDto;
import com.jiyunieo.demo.Repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DiaryRepository diaryRepository;
    public void save(DiaryDto diaryDto){
        Diary diary = new Diary();
        diary.setContent(diaryDto.getContent());
        this.diaryRepository.save(diary);
    }
}
