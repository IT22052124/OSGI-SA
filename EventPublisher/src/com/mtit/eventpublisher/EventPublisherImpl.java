package eventpublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventPublisherImpl implements EventPublisher {
    private List<Event> events = new ArrayList<>();

    public EventPublisherImpl() {
        events.add(new Event(1, "Teacher Workshop", "2023-10-15", "Workshop on teaching methodologies.", "teacher"));
        events.add(new Event(2, "Student Seminar", "2023-10-20", "Seminar on career opportunities.", "student"));
        events.add(new Event(3, "Science Fair", "2023-11-10", "Annual science fair for students.", "student"));
        events.add(new Event(4, "Staff Training", "2023-11-15", "Mandatory training for teachers.", "teacher"));
        events.add(new Event(5, "Sports Day", "2023-12-05", "Inter-school sports competition.", "student"));
        events.add(new Event(6, "Curriculum Review", "2023-12-10", "Discussion on curriculum updates.", "teacher"));
        events.add(new Event(7, "Cultural Festival", "2024-01-25", "Showcasing student talents.", "student"));
        events.add(new Event(8, "Parent-Teacher Meeting", "2024-02-10", "Meeting to discuss student progress.", "teacher"));
        events.add(new Event(9, "Annual Day Celebration", "2024-03-15", "Cultural performances and awards ceremony.", "student"));
        events.add(new Event(10, "Tech Expo", "2024-04-10", "Exhibition of innovative student projects, guided by teachers.", "student"));
        events.add(new Event(11, "Educational Trip", "2024-05-20", "Visit to a historical site for learning purposes.", "student"));
        events.add(new Event(12, "Teacher Conference", "2024-06-05", "Conference on modern teaching strategies.", "teacher"));
        events.add(new Event(13, "Teacher Training Workshop", "2024-07-12", "Advanced pedagogical methods workshop.", "teacher"));

    }

    @Override
    public List<Event> getEventsByAudience(String audience) {
        return events.stream()
                .filter(event -> event.getAudience().equals(audience))
                .collect(Collectors.toList());
    }

    @Override
    public Event getEventById(int eventId) {
        return events.stream()
                .filter(event -> event.getEventId() == eventId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Event not found with ID: " + eventId));
    }
}
