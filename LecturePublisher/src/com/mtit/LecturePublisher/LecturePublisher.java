package com.mtit.LecturePublisher;

import java.util.List;

public interface LecturePublisher {
    List<Lecture> getAllLectures();
    Lecture getLectureById(int lectureId);
}