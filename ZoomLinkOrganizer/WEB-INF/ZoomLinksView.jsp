<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>Zoom Links</title>
<link rel="stylesheet" href="/ZoomLinks.css">
</head>
<body>


<!-- Select Course Form -->
		<form >
	
		<select id="courseId" name="courseId">
			<c:forEach items="${courses}" var="course">
				<option value ="${course.courseId}" 
					<c:if test="${course.courseId eq selectedCourseId}">selected="selected"</c:if>
				>
  					${course.courseName}
  				</option>
			</c:forEach>
		</select>
	<input type="submit" value="Select"/>
	
	<a href="AddClass">Add Class</a>
	</form>

	
	<form action="ZoomLinksController" method="post">
	
	<table border=1 cellspacing=0 cellpadding=3>
		<c:forEach items="${courses[param.courseId].entries}" var="entries">
			<tr>
			<td>${entries.meetingType}</td>
			<td><a href="#">${entries.zoomLink}</a>
			<input type="hidden" name="entryId" value="${entries.entryId}">
			</td>
			<td><a href="RemoveLink?entryId=${entries.entryId}&courseId=${courses[param.courseId].courseId}">Delete</a></td> 
			</tr>
		 </c:forEach>
		 <tr>
		 	<td><input type = "text" name = "meetingType"></td>
		 	<td><input type = "text" name = "zoomLink">
		 	    <input type = "hidden" name= "courseId" value="${courses[param.courseId].courseId}">
		 	</td>
		
		 	<td><button>add</button></td>
		 </tr>
	</table>
	
	</form>
	
	
	
	
	
	<!-- List Zoom Links Form -->
	
	
	
</body>
</html>