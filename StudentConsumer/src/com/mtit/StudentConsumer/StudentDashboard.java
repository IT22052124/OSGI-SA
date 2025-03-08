package com.mtit.StudentConsumer;

import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.ChapterPublisher.ChapterPublisher;

public interface StudentDashboard {
    void getServices(LecturePublisher lecturePublisher, ChapterPublisher chapterPublisher);
}