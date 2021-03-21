package cs3220.model;
 
public class CourseEntry {
	
	
	static int idSeed = 0;
	private int entryId;
	
	private String meetingType;
	private String zoomLink;
	
	
	
	
	
	
	


	public CourseEntry(String meetingType, String zoomLink) {
		
		this.entryId = idSeed++;
		this.meetingType=meetingType;
		this.zoomLink=zoomLink;
				
	}
	
	
	
	public String getMeetingType() {
		return meetingType;
	}
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}
	public String getZoomLink() {
		return zoomLink;
	}
	public void setZoomLink(String zoomLink) {
		this.zoomLink = zoomLink;
	}
	public int getEntryId() {
		return entryId;
	}

}
