package com.mtit.LecturerConsumer;

import com.mtit.LecturePublisher.Lecture;
import com.mtit.ChapterPublisher.Chapter;

public class LecturerConsumerImpl implements LecturerConsumer {

    @Override
    public void reviewLectureAndChapter(Lecture lecture, Chapter chapter) {
        System.out.println("\n=== Lecturer Reviewing ===");
        System.out.println("Lecture ID: " + lecture.getLectureId());
        System.out.println("Lecture Title: " + lecture.getLectureName());
        System.out.println("Lecture Description: " + lecture.getLecturer());
        System.out.println("Chapter ID: " + chapter.getChapterId());
        System.out.println("Chapter Title: " + chapter.getChapterName());
        System.out.println("Chapter Summary: " + chapter.getChapterSummary());
        System.out.println("Status: Lecture " + lecture.getLectureId() + 
                           " and Chapter " + chapter.getChapterId() + " is being reviewed by the lecturer.");
    }
}