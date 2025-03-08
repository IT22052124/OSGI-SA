package com.mtit.LecturerConsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import java.util.Scanner;
import com.mtit.LecturePublisher.LecturePublisher;
import com.mtit.LecturePublisher.Lecture;
import com.mtit.ChapterPublisher.ChapterPublisher;
import com.mtit.ChapterPublisher.Chapter;

public class LecturerDashboardActivator implements BundleActivator {

    private ServiceReference<?> lectureServiceRef;
    private ServiceReference<?> chapterServiceRef;
    private Scanner scanner;

    public void start(BundleContext context) throws Exception {
        System.out.println("Lecturer Dashboard Started");

        // Get service references from producer bundles
        lectureServiceRef = context.getServiceReference(LecturePublisher.class.getName());
        chapterServiceRef = context.getServiceReference(ChapterPublisher.class.getName());

        LecturePublisher lecturePublisher = (LecturePublisher) context.getService(lectureServiceRef);
        ChapterPublisher chapterPublisher = (ChapterPublisher) context.getService(chapterServiceRef);

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== Lecturer Dashboard ==========");
            System.out.println("1 - Review Lecture & Chapter");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Exiting Lecturer Dashboard...");
                break;
            }

            System.out.print("Enter Lecture ID: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }
            int lectureId = scanner.nextInt();

            Lecture lecture = lecturePublisher.getLectureById(lectureId);
            if (lecture == null) {
                System.out.println("Invalid Lecture ID! Try again.");
                continue;
            }

            System.out.print("Enter Chapter ID: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }
            int chapterId = scanner.nextInt();

            Chapter chapter = chapterPublisher.getChapterById(chapterId);
            if (chapter == null || chapter.getLectureId() != lectureId) {
                System.out.println("Invalid Chapter ID for selected Lecture! Try again.");
                continue;
            }

            // Initialize Lecturer Consumer and review lecture & chapter
            LecturerConsumer lecturerConsumer = new LecturerConsumerImpl();
            lecturerConsumer.reviewLectureAndChapter(lecture, chapter);
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Lecturer Dashboard Stopped");
        context.ungetService(lectureServiceRef);
        context.ungetService(chapterServiceRef);
        
    }
}
