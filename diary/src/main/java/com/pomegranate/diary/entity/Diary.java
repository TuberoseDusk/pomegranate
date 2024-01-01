package com.pomegranate.diary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diary {

    private Long diaryId;

    private Long userId;
    private LocalDateTime recordDate;

    private String location;
    private Integer mood;

    private String writing;
    private String photo;
    private String video;

    private String tag;
}
