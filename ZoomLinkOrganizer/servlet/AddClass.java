package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Course;
import cs3220.model.CourseEntry;

@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddClass() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/AddClass.jsp").forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Course> courses = (List<Course>) getServletContext().getAttribute("courses");
		List<CourseEntry> entries =new ArrayList<CourseEntry>();
		Course course = new Course((String) request.getParameter("courseName"),entries);
		courses.add(course);
		
		
		response.sendRedirect( "ZoomLinksController?courseId="+course.getCourseId());
		return;
	
	}

}
