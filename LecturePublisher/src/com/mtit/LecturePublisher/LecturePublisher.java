package com.mtit.LecturePublisher;

import java.util.HashMap;

public interface LecturePublisher {
    void addLecture(int lectureId, String lectureName, String lecturer, String lectureDescription);
    Lecture getLectureById(int lectureId);
    HashMap<Integer, Lecture> getAllLectures();  //method to retrieve all lectures
}