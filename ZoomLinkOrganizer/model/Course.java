package cs3220.model;

import java.util.List;


public class Course {
	
	private String courseName;
	List<CourseEntry> entries;
	static int idSeed = 0;
	private int courseId;
	
	
	



	public Course (String courseName, List<CourseEntry> entries) {
		this.courseId = idSeed++;
		this.courseName=courseName;
		this.entries = entries;
	}
	
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<CourseEntry> getEntries() {
		return entries;
	}
	public void setEntries(List<CourseEntry> entries) {
		this.entries = entries;
	}
	public int getCourseId() {
		return courseId;
	}
		

}
