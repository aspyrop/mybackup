<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
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
					<li>
						<form action="AdminStudentsForClassPage" method="get">
							<a href = "AdminStudentsForClassPage">Students_4C</a>
						</form>
					</li>
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
			<h1>Administrator's Console</h1>
			
			<p>
			Please note that according to project specifications, administration (i.e. insertion, update, delete)<br>
			of the entities Classes, Subjects, Teachers and Students will not be taken care of here. Their relevant<br>
			data has already been registered (loaded) on their corresponding database tables.
			</p>
			
			<h3>Menu Selections</h3>
			
			<table style="width:100%">
			  <tr>
			    <th>Menu Selection</th>
			    <th>Menu Operation</th>
			    <th>Operation Description</th>
			  </tr>
			  <tr>
			    <td>Subjects_4C</td>
			    <td>Meaning: Subjects for a Class</td>
			    <td>This is the option in order to register (i.e. connect or link) the appropriate 'Subjects' for a 'Class'</td>
			  </tr>
			  <tr>
			    <td>Teachers_4C</td>
			    <td>Meaning: Teachers for a Class</td>
			    <td>This is the option in order to register (i.e. connect or link) the appropriate 'Teachers' for a 'Class'</td>
			  </tr>
			  <tr>
			    <td>Students_4C</td>
			    <td>Meaning: Students for a Class</td>
			    <td>This is the option in order to register (i.e. connect or link) the appropriate 'Students' for a 'Class'</td>
			  </tr>
			  <tr>
			    <td>Report_4C</td>
			    <td>Meaning: Report for a Class</td>
			    <td>This is the option in order to get a full Class Report, i.e. all Subjects, Teachers and Students related</td>
			  </tr>
			</table>
			
	<%	} %>

	<div>
		<br><font size="-2"><b><%= PAGE_FOOTER %></b></font>
	</div>
	
</body>
</html>