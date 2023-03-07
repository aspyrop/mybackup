<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Student" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students For Class Admin Page</title>
<link rel="stylesheet" href="style.css">

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>

</head>
<body>

	<%
	//set a "no-cache" filter on this current (ToBe secured) JSP page
	response.addHeader("Pragma", "no-cache"); //HTTP 1.0.
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", 0); //Proxies	
	
	//get global constants
	String COMPANY_NAME = pageContext.getServletContext().getInitParameter("COMPANY_NAME");
	String PAGE_FOOTER = pageContext.getServletContext().getInitParameter("PAGE_FOOTER");
	%>
	
	<div class="navbar">
		<ul>
			<%	String username = (String) session.getAttribute("username");
				if (username != null) {%>		
					<li><a href = "AdminPage.jsp">Home</a></li>
					<li><a href = "AdminSubjectsForClassPage.jsp">Subjects_4C</a></li>
					<li><a href = "AdminTeachersForClassPage.jsp">Teachers_4C</a></li>
					<li><a href = "AdminStudentsForClassPage.jsp">Students_4C</a></li>
					<li><a href = "AdminReportForClassPage.jsp">Report_4C</a></li>
					<li><a href = "LogoutPage.jsp">Logout</a></li>
			<% }
				else {
					response.sendRedirect("LoginPage.jsp");
				} %>
		</ul>
	</div>

	<%	if (username != null) {%>
	
			<h3><%= COMPANY_NAME %> | OnLine Management System</h3>
			<h1>Administrator's Console > Students for a Class</h1>
			Assign one of the Classes (A1, A2, A3) to each student and press button "Assign".<br><br>
			
			
		<%	List<Student> students = (List<Student>) request.getAttribute("students"); %>
					 
			<table style="width:100%">
				<tr>
			    	<th>Student ID</th>
			    	<th>Student Surname</th>
			    	<th>Student Name</th>
			    	<th>Student Middle Name</th>
			    	<th>A1|A2|A3 (Class)</th>			    			    	
				</tr>
			  
		<%	for (Student student: students) { %>
				<tr>
				    <td><%= student.getId() %></td>
				    <td><%= student.getSurname() %></td>
				    <td><%= student.getName() %></td>
				    <td><%= student.getMiddlename() %></td>
				    <td>
					    <form action="AdminStudentsForClassPage" method="post">
					    
						    <input type="radio" name="assignedclass" value="1" <% if (student.getClassID() == 1) %> checked> <% else %> >
						    <input type="radio" name="assignedclass" value="2" <% if (student.getClassID() == 2) %> checked> <% else %> >
						    <input type="radio" name="assignedclass" value="3" <% if (student.getClassID() == 3) %> checked> <% else %> >
							
							<input type="submit" value="Assign">
							
							<%
							//request.setAttribute("studentID", student.getId());					
							%>
							
						</form>
					</td>
				</tr>
		<%	} %>
			</table>
	<%	} %>

	<div>
		<br><font size="-2"><b><%= PAGE_FOOTER %></b></font>
	</div>
	
</body>
</html>