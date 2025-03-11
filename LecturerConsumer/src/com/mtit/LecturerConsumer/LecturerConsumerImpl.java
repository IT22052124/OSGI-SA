package com.mtit.LecturerConsumer;

import com.mtit.LecturePublisher.Lecture;
import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.ChapterPublisher.Chapter;
import com.mtit.ChapterPublisher.ChapterPublisher;
import java.util.Scanner;

public class LecturerConsumerImpl implements LecturerConsumer {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void reviewLecturesAndChapter(LecturePublisher lecturePublisher, ChapterPublisher chapterPublisher) {
        while (true) {
            System.out.print("Enter Lecture ID to Review: ");
            int lectureId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Lecture lecture = lecturePublisher.getLectureById(lectureId);
            if (lecture == null) {
                System.out.println("Invalid Lecture ID! Try again.");
                continue;
            }

            System.out.print("Enter Chapter ID to Review: ");
            int chapterId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Chapter chapter = chapterPublisher.getChapterById(chapterId);
            if (chapter == null || chapter.getLectureId() != lectureId) {
                System.out.println("Invalid Chapter ID for the given Lecture! Try again.");
                continue;
            }

            System.out.println("\n=== Lecturer Reviewing ===");
            System.out.println("Lecture ID: " + lecture.getLectureId());
            System.out.println("Lecture Title: " + lecture.getLectureName());
            System.out.println("Lecture Description: " + lecture.getLecturer());
            System.out.println("Chapter ID: " + chapter.getChapterId());
            System.out.println("Chapter Title: " + chapter.getChapterName());
            System.out.println("Chapter Summary: " + chapter.getChapterSummary());
            System.out.println("Status: Lecture " + lecture.getLectureId() + " and Chapter " + chapter.getChapterId() + " is being reviewed by the lecturer.\n");
            break;
        }
    }
}
