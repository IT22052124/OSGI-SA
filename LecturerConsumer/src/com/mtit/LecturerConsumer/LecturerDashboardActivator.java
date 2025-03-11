package com.mtit.LecturerConsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.ChapterPublisher.ChapterPublisher;
import java.util.Scanner;

public class LecturerDashboardActivator implements BundleActivator {

    private ServiceReference<?> lectureServiceRef;
    private ServiceReference<?> chapterServiceRef;
    private Scanner scanner = new Scanner(System.in);

    public void start(BundleContext context) throws Exception {
        System.out.println("Lecturer Dashboard Started");

        // Get service references from producer bundles
        lectureServiceRef = context.getServiceReference(LecturePublisher.class.getName());
        chapterServiceRef = context.getServiceReference(ChapterPublisher.class.getName());

        LecturePublisher lecturePublisher = (LecturePublisher) context.getService(lectureServiceRef);
        ChapterPublisher chapterPublisher = (ChapterPublisher) context.getService(chapterServiceRef);

        while (true) {
            System.out.println("\n========== Lecturer Dashboard ==========");
            System.out.println("1 - Add Lecture & Chapter");
            System.out.println("2 - Review Available Lectures & Chapters");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Exiting Lecturer Dashboard...");
                break;
            }

            switch (choice) {
                case 1:
                    addLectureAndChapter(lecturePublisher, chapterPublisher);
                    break;
                case 2:
                    LecturerConsumer lecturerConsumer = new LecturerConsumerImpl();
                    lecturerConsumer.reviewLecturesAndChapter(lecturePublisher, chapterPublisher);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addLectureAndChapter(LecturePublisher lecturePublisher, ChapterPublisher chapterPublisher) {
        System.out.print("Enter Lecture ID: ");
        int lectureId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Lecturer Name: ");
        String lectureName = scanner.nextLine();
        System.out.print("Enter Lecture Title: ");
        String lecturer = scanner.nextLine();
        System.out.print("Enter Lecture Description: ");
        String lectureDescription = scanner.nextLine();

        lecturePublisher.addLecture(lectureId, lectureName, lecturer, lectureDescription);

        System.out.print("Enter Chapter ID: ");
        int chapterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Chapter Title: ");
        String chapterTitle = scanner.nextLine();
        System.out.print("Enter Chapter Summary: ");
        String chapterSummary = scanner.nextLine();

        chapterPublisher.addChapter(lectureId, chapterId, chapterTitle, chapterSummary);

        System.out.println("Lecture and Chapter added successfully!");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Lecturer Dashboard Stopped");
        context.ungetService(lectureServiceRef);
        context.ungetService(chapterServiceRef);
    }
}