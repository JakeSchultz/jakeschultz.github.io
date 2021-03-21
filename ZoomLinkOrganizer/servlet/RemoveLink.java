package cs3220.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Course;
import cs3220.model.CourseEntry;


@WebServlet("/RemoveLink")
public class RemoveLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveLink() {
        super();
    }

    private Course getCourse(int courseId) {
    	List<Course> courses = (List<Course>) getServletContext().getAttribute("courses");
    	for (Course course : courses) {
    		if(course.getCourseId()==courseId)
    			return course;
    	}
    	return null;
    }
    private CourseEntry getCourseEntry(int courseId, int entryId) {
    	Course course = getCourse(courseId);
    	List<CourseEntry> courseEntries =(List<CourseEntry>) course.getEntries();
    	for(CourseEntry courseEntry : courseEntries) {
    		if(courseEntry.getEntryId()==entryId)
    			return courseEntry;
    	}
    	return null;
    	
    }
    	
    
    
    
    
	@SuppressWarnings({"unchecked"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int entriesId = Integer.parseInt(request.getParameter("entryId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		Course course = null;
		course = getCourse(courseId);
		CourseEntry courseEntry=null;
		courseEntry = getCourseEntry(courseId, entriesId);
			if(courseEntry != null) {
				course.getEntries().remove(courseEntry);
				
				response.sendRedirect( "ZoomLinksController?courseId="+courseId);
				return;
			}
		
	}
}
