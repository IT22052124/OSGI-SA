package lecturereventconsumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import announcementpublisher.Announcement;
import announcementpublisher.AnnouncementPublisher;
import eventpublisher.Event;
import eventpublisher.EventPublisher;

public class LecturerDashboardActivator implements BundleActivator {

    private ServiceReference<?> eventServiceRef;
    private ServiceReference<?> announcementServiceRef;
    private Scanner scanner;

    public void start(BundleContext context) throws Exception {
        System.out.println( "===== Lecturer Dashboard Started =====" );

        // Get service references from producer bundles
        eventServiceRef = context.getServiceReference(EventPublisher.class.getName());
        announcementServiceRef = context.getServiceReference(AnnouncementPublisher.class.getName());

        EventPublisher eventPublisher = (EventPublisher) context.getService(eventServiceRef);
        AnnouncementPublisher announcementPublisher = (AnnouncementPublisher) context.getService(announcementServiceRef);

        scanner = new Scanner(System.in);

        while (true) {
            System.out.println( "\n========== 📚 Lecturer Dashboard ==========" );
            System.out.println( "1 - Check Events" );
            System.out.println( "2 - Check Announcements" );
            System.out.println( "0 - Exit" );
            System.out.print( "Enter your choice: " );

            if (!scanner.hasNextInt()) {
                System.out.println( "⚠ Invalid input! Please enter a number." );
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println( "Exiting Lecturer Dashboard..." );
                break;
            }

            LecturerConsumer lecturerConsumer = new LecturerConsumerImpl(announcementPublisher);
            switch (choice) {
                case 1:
                    List<Event> events = eventPublisher.getEventsByAudience("teacher");
                    lecturerConsumer.reviewLecturerEvents(events);
                    break;

                case 2:
                    List<Announcement> standaloneAnnouncements = announcementPublisher.getStandaloneAnnouncements("teacher");
                    lecturerConsumer.reviewLecturerAnnouncements(standaloneAnnouncements);
                    break;

                default:
                    System.out.println( "⚠ Invalid choice! Please try again." );
                    break;
            }
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println( "===== Lecturer Dashboard Stopped =====" );
        context.ungetService(eventServiceRef);
        context.ungetService(announcementServiceRef);
        scanner.close();
    }
}
