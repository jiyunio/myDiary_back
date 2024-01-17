package com.jiyunieo.demo.Repository;

import com.jiyunieo.demo.Domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {

}
