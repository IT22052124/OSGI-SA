package announcementpublisher;

import java.util.List;

public interface AnnouncementPublisher {
    List<Announcement> getAnnouncementsByAudience(String audience);
    List<Announcement> getAnnouncementsByEventId(int eventId);
    List<Announcement> getStandaloneAnnouncements(String audience);
    Announcement getAnnouncementById(int announcementId);
}
