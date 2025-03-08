package com.mtit.LecturePublisher;

import java.util.ArrayList;
import java.util.List;

public class LecturePublisherImpl implements LecturePublisher {
    private List<Lecture> lectures = new ArrayList<>();

    public LecturePublisherImpl() {
        lectures.add(new Lecture(1, "Introduction to OSGi", "Dr. Smith", "2025-03-10"));
        lectures.add(new Lecture(2, "Modular Programming", "Prof. Johnson", "2025-03-12"));
        lectures.add(new Lecture(3, "Service Components", "Dr. Williams", "2025-03-15"));
    }

    @Override
    public List<Lecture> getAllLectures() {
        return lectures;
    }

    @Override
    public Lecture getLectureById(int lectureId) {
        return lectures.stream()
                .filter(lecture -> lecture.getLectureId() == lectureId)
                .findFirst()
                .orElse(null);
    }
}