package lecturereventconsumer;

import java.util.List;

import announcementpublisher.Announcement;
import eventpublisher.Event;

public interface LecturerConsumer {
    void reviewLecturerEvents(List<Event> events);
    void reviewLecturerAnnouncements(List<Announcement> announcements);
}
