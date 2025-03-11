package lecturereventconsumer;

import java.util.List;
import announcementpublisher.Announcement;
import announcementpublisher.AnnouncementPublisher;
import eventpublisher.Event;

public class LecturerConsumerImpl implements LecturerConsumer {

    private final AnnouncementPublisher announcementPublisher;

    // Constructor to inject the AnnouncementPublisher dependency
    public LecturerConsumerImpl(AnnouncementPublisher announcementPublisher) {
        this.announcementPublisher = announcementPublisher;
    }

    @Override
    public void reviewLecturerEvents(List<Event> events) {
        System.out.println("\n======== 📅 Events for Lecturers ========" );

        if (events == null || events.isEmpty()) {
            System.out.println("⚠ No upcoming events for lecturers." );
            return;
        }

        for (Event event : events) {
            System.out.println("🔹 Event ID: "  + event.getEventId());
            System.out.println("   Event Name: "  + event.getEventName());
            System.out.println("   Event Date: "  + event.getEventDate());
            System.out.println("   Description: " + event.getEventDescription());

            List<Announcement> eventAnnouncements = announcementPublisher.getAnnouncementsByEventId(event.getEventId());
            if (eventAnnouncements != null && !eventAnnouncements.isEmpty()) {
                System.out.println("\n🔔 " + "Linked Announcements:" );
                printAnnouncementTable(eventAnnouncements);
            } else {
                System.out.println( "❌ No linked announcements." );
            }
            System.out.println( "---------------------------------------------" );
        }
    }

    @Override
    public void reviewLecturerAnnouncements(List<Announcement> announcements) {
        System.out.println( "\n===== 📢 Announcements for Lecturers =====" );

        if (announcements == null || announcements.isEmpty()) {
            System.out.println( "⚠ No Announcements for lecturers." );
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
