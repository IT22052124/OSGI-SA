package com.mtit.LecturerConsumer;


import com.mtit.LecturePublisher.Lecture;
import com.mtit.ChapterPublisher.Chapter;

public interface LecturerConsumer {
    void reviewLectureAndChapter(Lecture lecture, Chapter chapter);
}