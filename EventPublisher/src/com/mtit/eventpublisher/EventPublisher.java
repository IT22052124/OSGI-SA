package eventpublisher;

import java.util.List;

public interface EventPublisher {
    List<Event> getEventsByAudience(String audience);
    Event getEventById(int eventId);
}
