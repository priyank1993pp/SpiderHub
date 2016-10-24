<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpiderHub</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<security:authorize access="anonymous">
		<a href="<c:url value='/login.html' />">Login</a>
	</security:authorize>
	<p>WELCOME TO SpiderHub</p>
	<security:authorize access="authenticated">
		<security:authorize access="hasAnyRole('ADMIN','MANAGER')">
			<ul>
				<li><a href="projects/list.html">Project Management</a></li>
				<li><a href="task/list.html">Task Management</a></li>
				<li><a href='userRegistration.html'>Add User</a></li>
			</ul>
		</security:authorize>
		<security:authorize access="hasRole('MEMBER')">
			<ul>
				<li><a href="task/list.html">Task Management</a></li>
			</ul>
		</security:authorize>
		<a href="<c:url value='/logout' />">Logout</a> |
  </security:authorize>

</body>
</html>