package com.pomegranate.diary.mapper;

import com.pomegranate.diary.entity.Diary;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DiaryMapper {
    Integer insert(Diary diary);

    Diary selectByUserIdAndRecordDate(Long userId, LocalDate date);

    List<Diary> selectByUserId(Long userId);

}
