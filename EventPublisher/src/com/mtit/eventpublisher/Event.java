package eventpublisher;

public class Event {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventDescription;
    private String audience;
    
    public Event(int eventId,String eventName, String eventDate,String eventDescription, String audience) {
    	this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.audience = audience;
    }
    
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}

	@Override
	public String toString() {
		return "[event Id : " + eventId +
				"\nevent Name : " + eventName + 
				"\nevent Date : " + eventDate + 
				"\nevent Description : " + eventDescription + 
				"\naudience : " + audience ;
	} 
    
	

}