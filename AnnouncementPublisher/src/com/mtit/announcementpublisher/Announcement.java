package announcementpublisher;

public class Announcement {
	private int announcementId;
    private String announcementTitle;
    private String announcementMessage;
    private String announcementDate;
    private Integer  eventId; 
    private String audience;
    
    
	public Announcement(int announcementId, String announcementTitle, String announcementMessage,
			String announcementDate, Integer eventId, String audience) {
		this.announcementId = announcementId;
		this.announcementTitle = announcementTitle;
		this.announcementMessage = announcementMessage;
		this.announcementDate = announcementDate;
		this.eventId = eventId;
		this.audience = audience;
	}
	
	public int getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	public String getAnnouncementMessage() {
		return announcementMessage;
	}
	public void setAnnouncementMessage(String announcementMessage) {
		this.announcementMessage = announcementMessage;
	}
	public String getAnnouncementDate() {
		return announcementDate;
	}
	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getAudience() {
		return audience;
	}
	public void setAudience(String audience) {
		this.audience = audience;
	}

	@Override
	public String toString() {
		return "Announcement Id : " + announcementId + 
				"\nAnnouncement Title : " + announcementTitle + 
				"\nAnnouncement Message : " + announcementMessage + 
				"\nAnnouncement Date : " + announcementDate + 
				"\nEvent Id : " + eventId + 
				"\nAudience : " + audience ;
	}
    
    

}
