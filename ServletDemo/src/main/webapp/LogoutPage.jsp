<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<!--<body text-align="left">-->

	<%
	//get global constants
	String COMPANY_NAME = pageContext.getServletContext().getInitParameter("COMPANY_NAME");
	String PAGE_FOOTER = pageContext.getServletContext().getInitParameter("PAGE_FOOTER");
	%>
	
	<div class="navbar">
		<ul>
			<li><a href = "index.jsp">Home</a></li>
			<li><a href = "#">*About</a></li>
			<li><a href = "#">*Classes</a></li>
			<li><a href = "#">*Projects</a></li>
			<li><a href = "#">*News</a></li>
			<li><a href = "#">*Contact</a></li>
			<li><a href = "LoginPage.jsp">Admin</a></li>
		</ul>
	</div>
	
	<%	String username = (String) session.getAttribute("username");
		if (username != null) {
	
			session.removeAttribute("username");
			session.invalidate();%>
			
			<h3><%= COMPANY_NAME %> | OnLine Management System</h3>
			<h1>Administrator's Logout</h1>
			
			<div class="container">
				<b><u>System Message</u></b>
				<p style="color:red">Thanks for using the Online Management System.</p>
			</div>

	<%	} %>

	<div>
		<br><font size="-2"><b><%= PAGE_FOOTER %></b></font>
	</div>
	
</body>
</html>