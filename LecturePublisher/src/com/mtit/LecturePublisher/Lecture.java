package com.mtit.LecturePublisher;

public class Lecture {

    private int lectureId;
    private String lectureName;
    private String lecturer;
    private String lectureDescription;

    public Lecture(int lectureId, String lectureName, String lecturer, String lectureDescription) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.lecturer = lecturer;
        this.lectureDescription = lectureDescription;
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getLectureDescription() {
        return lectureDescription;
    }

    @Override
    public String toString() {
        return "Lecture ID: " + lectureId + "\n" +
               "Lecture Name: " + lectureName + "\n" +
               "Lecturer: " + lecturer + "\n" +
               "Description: " + lectureDescription + "\n";
    }
}