package studentexamconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import exampublisher.*;
import quizpublisher.*;

import java.util.Scanner;
import java.util.List;

public class StudentExamDashboardActivator implements BundleActivator {
    private ServiceReference<?> examServiceRef;
    private ServiceReference<?> quizServiceRef;
    private Scanner scanner;

    public void start(BundleContext context) throws Exception {
        System.out.println("========================================");
        System.out.println("      Student Exam Dashboard Started    ");
        System.out.println("========================================");

        examServiceRef = context.getServiceReference(ExamPublisher.class.getName());
        quizServiceRef = context.getServiceReference(QuizPublisher.class.getName());

        ExamPublisher examPublisher = (ExamPublisher) context.getService(examServiceRef);
        QuizPublisher quizPublisher = (QuizPublisher) context.getService(quizServiceRef);

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========================================");
            System.out.println("        Student Exam Dashboard          ");
            System.out.println("========================================");
            System.out.println("  1 - Take Exam & Quiz");
            System.out.println("  0 - Exit");
            System.out.print("  Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("  Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            System.out.println("----------------------------------------");

            if (choice == 0) {
                System.out.println("  Exiting Student Exam Dashboard...");
                break;
            } else if (choice == 1) {
                System.out.print("  Enter Exam ID: ");
                int examId = scanner.nextInt();
                scanner.nextLine(); 

                Exam exam = examPublisher.getExamById(examId);
                if (exam != null) {
                    System.out.println("\n========================================");
                    System.out.println("        Exam Details");
                    System.out.println("========================================");
                    System.out.println("  Exam ID: " + exam.getExamId());
                    System.out.println("  Exam Name: " + exam.getExamName());
                    System.out.println("----------------------------------------");

                    
                    List<Quiz> quizzes = quizPublisher.getQuizzesByExamId(examId);
                    if (quizzes.isEmpty()) {
                        System.out.println("  No quizzes available for this exam.");
                    } else {
                        System.out.println("  Available Quizzes:");
                        for (Quiz quiz : quizzes) {
                            System.out.println("  Quiz ID: " + quiz.getQuizId() + " | Quiz Name: " + quiz.getQuizName());
                        }

                        System.out.print("\n  Enter Quiz ID: ");
                        int quizId = scanner.nextInt();
                        scanner.nextLine();

                        Quiz quiz = quizPublisher.getQuizById(quizId);
                        if (quiz != null && quiz.getExamId() == examId) {
                            System.out.println("\n========================================");
                            System.out.println("        Quiz Details");
                            System.out.println("========================================");
                            System.out.println("  Quiz ID: " + quiz.getQuizId());
                            System.out.println("  Quiz Name: " + quiz.getQuizName());
                            System.out.println("----------------------------------------");

                            
                            System.out.println("\n========================================");
                            System.out.println("       Student Taking the Exam...");
                            System.out.println("========================================");
                            System.out.println("  Student is now attempting the Exam: " + exam.getExamName());
                            System.out.println("  Student is now attempting the Quiz: " + quiz.getQuizName());
                            System.out.println("  Answering questions...");
                     
                            System.out.println("  Exam and Quiz Completed Successfully!");
                        } else {
                            System.out.println("  Invalid Quiz ID for the selected Exam.");
                        }
                    }
                } else {
                    System.out.println("  Exam not found with ID: " + examId);
                }
            } else {
                System.out.println("  Invalid choice! Please try again.");
            }
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("========================================");
        System.out.println("     Student Exam Dashboard Stopped     ");
        System.out.println("========================================");

        context.ungetService(examServiceRef);
        context.ungetService(quizServiceRef);
        scanner.close();
    }
}
