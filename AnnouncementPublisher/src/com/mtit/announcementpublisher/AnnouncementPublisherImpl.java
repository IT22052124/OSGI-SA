package announcementpublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnnouncementPublisherImpl implements AnnouncementPublisher {
    private List<Announcement> announcements = new ArrayList<>();

    public AnnouncementPublisherImpl() {
    	announcements.add(new Announcement(1, "Teacher Meeting", "Monthly teacher meeting on 2023-10-10.", "2023-10-05", null, "teacher"));
        announcements.add(new Announcement(2, "Student Registration", "Register for the seminar by 2023-10-18.", "2023-10-15", 2, "student"));
        announcements.add(new Announcement(9, "Annual Day Celebration Info", "Join us for our grand Annual Day on 2024-03-15.", "2024-03-05", 9, "student"));
        announcements.add(new Announcement(10, "Tech Expo Registration", "Submit your project ideas for Tech Expo by 2024-03-25.", "2024-03-10", 10, "student"));
        announcements.add(new Announcement(11, "Educational Trip Details", "Consent forms for the trip should be submitted by 2024-05-10.", "2024-05-01", 11, "student"));
        announcements.add(new Announcement(12, "Teacher Conference Invite", "All teachers are invited to the modern teaching strategies conference.", "2024-05-25", 12, "teacher"));
        announcements.add(new Announcement(13, "Teacher Training Registration", "Register for the upcoming advanced pedagogical workshop.", "2024-06-25", 13, "teacher"));
    }

    public List<Announcement> getAnnouncementsByAudience(String audience) {
        return announcements.stream()
                .filter(announcement -> announcement.getAudience().equals(audience))
                .collect(Collectors.toList());
    }

    public List<Announcement> getAnnouncementsByEventId(int eventId) {
        return announcements.stream()
                .filter(announcement -> announcement.getEventId() != null && announcement.getEventId() == eventId)
                .collect(Collectors.toList());
    }

    public List<Announcement> getStandaloneAnnouncements(String audience) {
        return announcements.stream()
                .filter(announcement -> announcement.getEventId() == null && announcement.getAudience().equals(audience))
                .collect(Collectors.toList());
    }

    public Announcement getAnnouncementById(int announcementId) {
        return announcements.stream()
                .filter(announcement -> announcement.getAnnouncementId() == announcementId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Announcement not found with ID: " + announcementId));
    }
}
