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

    public Integer crete(DiaryDto diaryDto) {
        Diary diary = new Diary();

        diary.setContents(diaryDto.getContents());
        diary.setX(diary.getX());
        diary.setY(diary.getY());
        return diaryRepository.save(diary).getId();
    }

    public void delete(DiaryDto diaryDto) {
    }
}
