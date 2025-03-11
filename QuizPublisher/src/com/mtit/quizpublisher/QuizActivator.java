package quizpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import exampublisher.ExamPublisher;

import java.util.Scanner;

public class QuizActivator implements BundleActivator {
    private ServiceRegistration<?> quizServiceRegistration;
    private ServiceReference<?> examServiceRef;
    private Scanner scanner;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("========================================");
        System.out.println("         Quiz Publisher Started         ");
        System.out.println("========================================");

       
        examServiceRef = context.getServiceReference(ExamPublisher.class.getName());
        ExamPublisher examPublisher = (ExamPublisher) context.getService(examServiceRef);

        
        QuizPublisher quizPublisher = new QuizPublisherImpl(examPublisher);
        quizServiceRegistration = context.registerService(QuizPublisher.class.getName(), quizPublisher, null);

        
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n========================================");
            System.out.println("          Quiz Publisher Menu           ");
            System.out.println("========================================");
            System.out.println("  1 - Add Quiz");
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
                System.out.println("  Exiting Quiz Publisher Menu...");
                break;
            } else if (choice == 1) {
                System.out.print("  Enter Exam ID: ");
                int examId = scanner.nextInt();

                System.out.print("  Enter Quiz ID: ");
                int quizId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("  Enter Quiz Name: ");
                String quizName = scanner.nextLine();
                System.out.print("  Enter Quiz Questions: ");
                String quizQuestions = scanner.nextLine();

                Quiz quiz = new Quiz(quizId, examId, quizName, quizQuestions);
                quizPublisher.addQuiz(quiz);
            } else {
                System.out.println("  Invalid choice! Please try again.");
            }
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("========================================");
        System.out.println("         Quiz Publisher Stopped         ");
        System.out.println("========================================");

        quizServiceRegistration.unregister();
        context.ungetService(examServiceRef);
        if (scanner != null) {
            scanner.close();
        }
    }
}
