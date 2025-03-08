package com.mtit.StudentConsumer;

import com.mtit.LecturePublisher.Lecture;
import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.ChapterPublisher.Chapter;
import com.mtit.ChapterPublisher.ChapterPublisher;
import java.util.Scanner;

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
            System.out.println("1 - Select Lecture");
            System.out.println("0 - Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
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

    private void handleLectureSelection() {
        System.out.print("Enter Lecture Number: ");
        int lectureId = scanner.nextInt();
        Lecture lecture = lecturePublisher.getLectureById(lectureId);

        if (lecture == null) {
            System.out.println("Invalid Lecture Number.");
            return;
        }

        System.out.println("\n" + lecture);
        System.out.print("Enter Chapter Number: ");
        int chapterId = scanner.nextInt();
        Chapter chapter = chapterPublisher.getChapterById(chapterId);

        if (chapter == null || chapter.getLectureId() != lectureId) {
            System.out.println("Invalid Chapter Number for selected Lecture.");
            return;
        }

        System.out.println("\nStudent is consuming Lecture " + lectureId + " of Chapter " + chapterId);
        System.out.println("\n" + chapter);
    }
}