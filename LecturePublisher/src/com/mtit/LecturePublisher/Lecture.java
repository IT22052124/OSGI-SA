package com.mtit.LecturePublisher;

public class Lecture {
    private int lectureId;
    private String lectureName;
    private String lecturer;
    private String lectureDate;
    
    public Lecture(int lectureId, String lectureName, String lecturer, String lectureDate) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.lecturer = lecturer;
        this.lectureDate = lectureDate;
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

    public String getLectureDate() {
        return lectureDate;
    }

    @Override
    public String toString() {
        return "Lecture ID: " + lectureId + 
               "\nLecture Name: " + lectureName + 
               "\nLecturer: " + lecturer + 
               "\nDate: " + lectureDate;
    }
}