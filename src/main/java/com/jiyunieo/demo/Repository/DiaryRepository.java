package com.jiyunieo.demo.Repository;

import com.jiyunieo.demo.Domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    Optional<Diary> findById(Integer id);
}
