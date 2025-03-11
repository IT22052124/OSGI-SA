package com.mtit.LecturerConsumer;


import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.ChapterPublisher.ChapterPublisher;

public interface LecturerConsumer {
    void reviewLecturesAndChapter(LecturePublisher lecturePublisher, ChapterPublisher chapterPublisher);
}