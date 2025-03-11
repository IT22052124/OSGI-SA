package studenteventconsumer;

import java.util.List;
import announcementpublisher.Announcement;
import announcementpublisher.AnnouncementPublisher;
import eventpublisher.Event;

public class StudentConsumerImpl implements StudentConsumer {
    
    private final AnnouncementPublisher announcementPublisher;


    public StudentConsumerImpl(AnnouncementPublisher announcementPublisher) {
        this.announcementPublisher = announcementPublisher;
    }

    @Override
    public void reviewStudentEvents(List<Event> events) {
        System.out.println("\n===== 🎓 Events for Students =====");

        if (events == null || events.isEmpty()) {
            System.out.println("⚠ No upcoming events for students." );
            return;
        }

        for (Event event : events) {
            System.out.println("🔹 Event ID: "  + event.getEventId());
            System.out.println("   Event Name: " + event.getEventName());
            System.out.println("   Event Date: "  + event.getEventDate());
            System.out.println("   Description: " + event.getEventDescription());

            // Fetch announcements linked to this event
            List<Announcement> eventAnnouncements = announcementPublisher.getAnnouncementsByEventId(event.getEventId());
            if (eventAnnouncements != null && !eventAnnouncements.isEmpty()) {
                System.out.println("\n🔔 Linked Announcements:" );
                printAnnouncementTable(eventAnnouncements);
            } else {
                System.out.println("❌ No linked announcements." );
            }
            System.out.println( "---------------------------------------------" );
        }
    }

    @Override
    public void reviewStudentAnnouncements(List<Announcement> announcements) {
        System.out.println( "\n===== 📢 Announcements for Students =====" );

        if (announcements == null || announcements.isEmpty()) {
            System.out.println( "⚠ No announcements for students." );
            return;
        }

        printAnnouncementTable(announcements);
    }

    private void printAnnouncementTable(List<Announcement> announcements) {
        System.out.println( "+-----------------------------------------------------------+" );
        System.out.printf( "| %-10s | %-25s | %-12s |%n" , "ID", "Title", "Date");
        System.out.println( "+-----------------------------------------------------------+" );

        for (Announcement announcement : announcements) {
            System.out.printf("| %-10s | %-25s | %-12s |%n",
                    announcement.getAnnouncementId(),
                    announcement.getAnnouncementTitle(),
                    announcement.getAnnouncementDate());
        }

        System.out.println( "+-----------------------------------------------------------+" );
    }
}
