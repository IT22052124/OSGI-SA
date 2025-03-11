package com.mtit.StudentCourseConsumer;

import com.mtit.LecturePublisher.Lecture;
import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.ChapterPublisher.Chapter;
import com.mtit.ChapterPublisher.ChapterPublisher;
import java.util.Scanner;

import java.util.Map;

public class StudentDashboardImpl implements StudentDashboard {
    private LecturePublisher lecturePublisher;
    private ChapterPublisher chapterPublisher;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void getServices(LecturePublisher lecturePublisher, ChapterPublisher chapterPublisher) {
        this.lecturePublisher = lecturePublisher;
        this.chapterPublisher = chapterPublisher;
        displayMenu();
    }

    private void displayMenu() {
        while (true) {
            System.out.println("\n========== Student Dashboard ==========");
            System.out.println("Available Lectures:");
            displayLectures();

            System.out.println("\n1 - Select Lecture");
            System.out.println("0 - Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                handleLectureSelection();
            } else if (choice == 0) {
                System.out.println("Exiting Student Dashboard...");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    private void displayLectures() {
        Map<Integer, Lecture> lectures = lecturePublisher.getAllLectures();

        if (lectures.isEmpty()) {
            System.out.println("No lectures available.");
        } else {
            for (Lecture lecture : lectures.values()) {
                System.out.println("Lecture ID: " + lecture.getLectureId() +
                                   ", Title: " + lecture.getLectureName() +
                                   ", Lecturer: " + lecture.getLecturer() +
                                   ", Description: " + lecture.getLectureDescription());
            }
        }
    }

    private void handleLectureSelection() {
        System.out.print("Enter Lecture Number: ");
        int lectureId = scanner.nextInt();
        scanner.nextLine();

        Lecture lecture = lecturePublisher.getLectureById(lectureId);

        if (lecture == null) {
            System.out.println("Invalid Lecture Number.");
            return;
        }

        System.out.println("\nLecture: " + lecture.getLectureName());
        displayChapters(lectureId);

        System.out.print("Enter Chapter Number: ");
        int chapterId = scanner.nextInt();
        scanner.nextLine();

        Chapter chapter = chapterPublisher.getChapterById(chapterId);

        if (chapter == null || chapter.getLectureId() != lectureId) {
            System.out.println("Invalid Chapter Number for selected Lecture.");
            return;
        }

        System.out.println("\nStudent is consuming Lecture " + lectureId + " of Chapter " + chapterId);
        System.out.println("\nChapter: " + chapter.getChapterName());
        System.out.println("Summary: " + chapter.getChapterSummary());
    }

    private void displayChapters(int lectureId) {
        Map<Integer, Chapter> chapters = chapterPublisher.getAllChapters();

        if (chapters.isEmpty()) {
            System.out.println("No chapters available for this lecture.");
        } else {
            for (Chapter chapter : chapters.values()) {
                if (chapter.getLectureId() == lectureId) {
                    System.out.println("Chapter ID: " + chapter.getChapterId() + 
                                       ", Title: " + chapter.getChapterName() +
                                       ", Summary: " + chapter.getChapterSummary());
                }
            }
        }
    }
}