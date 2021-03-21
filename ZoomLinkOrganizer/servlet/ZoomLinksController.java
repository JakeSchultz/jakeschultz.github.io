package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import cs3220.model.Course;
import cs3220.model.CourseEntry;
 
 

@WebServlet(urlPatterns = "/ZoomLinksController", loadOnStartup = 1 )
public class ZoomLinksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ZoomLinksController() {
        super();
    
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		List<Course> courses = new ArrayList<Course>();
		List<CourseEntry> entries =new ArrayList<CourseEntry>();
		
		entries.add(new CourseEntry("Lecture","https://calstatela.zoom.us/j/12345"));
		entries.add(new CourseEntry("Lab", "https://calstatela.zoom.us/j/23456"));
		courses.add(new Course("CS3220",entries));
		
		
		getServletContext().setAttribute("courses", courses);
		
		
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
    	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseId=0;
		if (request.getParameter("courseId")!=null) {
			courseId=Integer.parseInt(request.getParameter("courseId"));
		}
		request.setAttribute("selectedCourseId", courseId);
		request.getRequestDispatcher( "/WEB-INF/ZoomLinksView.jsp?courseId="+request.getAttribute("selectedCourseId")).forward( request, response );
		
		
	}
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CourseEntry> entries = (List<CourseEntry>) getServletContext().getAttribute("entries");
		
		List<Course> courses = (List<Course>) getServletContext().getAttribute("courses");
		//Pull attributes from Add Form
		String courseName = (String) request.getParameter("courseName");
		String meetingType =(String) request.getParameter("meetingType");
		String zoomLink = (String) request.getParameter("zoomLink");
		
		//id for the Course
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		
		//TODO: 
		Course course = null;
		course = getCourse(courseId);
		if(course==null) {
			response.sendRedirect( "AddCourse");
			return;
		}
		List<CourseEntry> courseEntries =(List<CourseEntry>) course.getEntries();
		courseEntries.add(new CourseEntry(meetingType, zoomLink));
		response.sendRedirect( "ZoomLinksController?courseId="+courseId);
		return;
		}
			
			
		
	
	
}

