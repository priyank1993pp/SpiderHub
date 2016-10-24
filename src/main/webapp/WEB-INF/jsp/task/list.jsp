<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Task Management</title>
</head>
<body>
	<h2>Task Management</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>TaskName</th>
			<th>Description</th>
			<th>createDate</th>
			<th>startDate</th>
			<th>endDate</th>
			<th>Operations</th>
			<c:forEach items="${tasks}" var="task">
				<tr>
					<td>${task.id}</td>
					<td>${task.taskName}</td>
					<td>${task.taskDescription}</td>
					<td>${task.createDate}</td>
					<td>${task.startDate}</td>
					<td>${task.endDate}</td>
					<td><a href="view.html?id=${task.id}">View</a> <a
						href="view/${task.id}.html">View2</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<p>
		<a href="add.html">Add new Task</a>
	</p>
</body>
</html>