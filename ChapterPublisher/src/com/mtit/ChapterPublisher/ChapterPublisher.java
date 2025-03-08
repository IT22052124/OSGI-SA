package com.mtit.ChapterPublisher;


import java.util.List;

public interface ChapterPublisher {
    List<Chapter> getChaptersByLectureId(int lectureId);
    Chapter getChapterById(int chapterId);
}