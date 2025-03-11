package studenteventconsumer;

import java.util.List;

import announcementpublisher.Announcement;
import eventpublisher.Event;

public interface StudentConsumer {
	void reviewStudentEvents(List<Event> events);
    void reviewStudentAnnouncements(List<Announcement> announcements);
}
