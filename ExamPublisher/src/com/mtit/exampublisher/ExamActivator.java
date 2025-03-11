package exampublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Scanner;

public class ExamActivator implements BundleActivator {
    private ServiceRegistration<?> examServiceRegistration;
    private Scanner scanner;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("========================================");
        System.out.println("        Exam Publisher Started          ");
        System.out.println("========================================");

        ExamPublisher examPublisher = new ExamPublisherImpl();
        examServiceRegistration = context.registerService(ExamPublisher.class.getName(), examPublisher, null);

       
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n========================================");
            System.out.println("         Exam Publisher Menu            ");
            System.out.println("========================================");
            System.out.println("  1 - Add Exam");
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
                System.out.println("  Exiting Exam Publisher Menu...");
                break;
            } else if (choice == 1) {
                System.out.print("  Enter Exam ID: ");
                int examId = scanner.nextInt();
                System.out.print("  Enter Course ID: ");
                int courseId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("  Enter Exam Name: ");
                String examName = scanner.nextLine();
                System.out.print("  Enter Exam Description: ");
                String examDescription = scanner.nextLine();

                Exam exam = new Exam(examId, courseId, examName, examDescription);
                examPublisher.addExam(exam);
            } else {
                System.out.println("  Invalid choice! Please try again.");
            }
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("========================================");
        System.out.println("        Exam Publisher Stopped          ");
        System.out.println("========================================");

        examServiceRegistration.unregister();
        if (scanner != null) {
            scanner.close();
        }
    }
}
