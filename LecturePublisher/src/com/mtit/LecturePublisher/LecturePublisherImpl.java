package com.mtit.LecturePublisher;

import java.util.HashMap;

public class LecturePublisherImpl implements LecturePublisher {

    private HashMap<Integer, Lecture> lectures = new HashMap<>();

    public LecturePublisherImpl() {
        // Adding some sample lectures for testing purposes
        addLecture(1, "Introduction to OSGi", "Dr. Smith", "Overview of OSGi Framework.");
        addLecture(2, "OSGi Services", "Prof. John", "Deep dive into OSGi service architecture.");
    }

    @Override
    public void addLecture(int lectureId, String lectureName, String lecturer, String lectureDescription) {
        Lecture lecture = new Lecture(lectureId, lectureName, lecturer, lectureDescription);
        lectures.put(lectureId, lecture);
        System.out.println("Lecture added successfully: " + lectureName);
    }

    @Override
    public Lecture getLectureById(int lectureId) {
        return lectures.get(lectureId);
    }

    @Override
    public HashMap<Integer, Lecture> getAllLectures() {
        return lectures;
    }
}